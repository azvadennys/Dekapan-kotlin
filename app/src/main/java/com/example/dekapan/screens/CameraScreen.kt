package com.example.dekapan.screens

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.dekapan.ml.Model
import com.example.dekapan.models.DiseaseInfo
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import org.tensorflow.lite.task.vision.classifier.ImageClassifier
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.Interpreter

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()  // Tambahkan scroll state

    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var detectedClass by remember { mutableStateOf("") }
    var diseaseDetails by remember { mutableStateOf("") }
    var solutionDetails by remember { mutableStateOf("") }
    var confidenceValue by remember { mutableStateOf("") }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val bitmap = uriToBitmap(context, it)
            bitmap?.let { bmp ->
                imageBitmap = bmp
                val (classPredict, confidence) = classifyImage(context, bmp)
                detectedClass = "Prediksi : $classPredict"
                diseaseDetails = DiseaseInfo.getDiseaseDetail(classPredict)
                solutionDetails = "Solusi :\n${DiseaseInfo.getSolutionDetail(classPredict)}"
                confidenceValue = "Confidence Score : $confidence%"
            }
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        bitmap?.let {
            imageBitmap = it
            val (classPredict, confidence) = classifyImage(context, it)
            detectedClass = "Prediksi : $classPredict"
            diseaseDetails = DiseaseInfo.getDiseaseDetail(classPredict)
            solutionDetails = "Solusi :\n${DiseaseInfo.getSolutionDetail(classPredict)}"
            confidenceValue = "Confidence Score : $confidence%"

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),  // Membuat scrollable
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Gunakan Kamera atau Pilih Gambar untuk memprediksi",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        imageBitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Meratakan tombol di dalam row
        ) {
            Button(
                onClick = { cameraLauncher.launch(null) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF388E3C), // Warna latar tombol
                    contentColor = Color.White // Warna teks dalam tombol
                )

            ) {
                Text("Buka Kamera")
            }

            Button(
                onClick = { galleryLauncher.launch("image/*") },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF388E3C), // Warna latar tombol
                    contentColor = Color.White // Warna teks dalam tombol
                )
            ) {
                Text("Pilih dari Galeri")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

// Detected class & confidence (rata kiri)
        Text(
            text = detectedClass,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Left, // Rata kiri
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = confidenceValue,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Left, // Rata kiri
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

// Disease details & solution details (justify)
        Text(
            text = diseaseDetails,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify, // Rata kiri-kanan (justify)
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = solutionDetails,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify, // Rata kiri-kanan (justify)
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Konversi URI ke Bitmap
fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
    return try {
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    } catch (e: IOException) {
        Log.e("CameraScreen", "Error loading image: ${e.message}")
        null
    }
}

// Fungsi klasifikasi gambar dengan TensorFlow Lite
fun classifyImage(context: Context, image: Bitmap): Pair<String, Int> {
    val model = Model.newInstance(context)

// Creates inputs for reference.
    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

    // Konversi gambar ke ukuran 224x224
    val resizedBitmap = Bitmap.createScaledBitmap(image, 224, 224, true)

    val byteBuffer = ByteBuffer.allocateDirect(4 * 224 * 224 * 3)
    byteBuffer.order(ByteOrder.nativeOrder())

    inputFeature0.loadBuffer(byteBuffer)

    val intValues = IntArray(224 * 224)
    resizedBitmap.getPixels(intValues, 0, resizedBitmap.width, 0, 0, resizedBitmap.width, resizedBitmap.height)

    var pixel = 0
    for (i in 0 until 224) {
        for (j in 0 until 224) {
            val value = intValues[pixel++]
            byteBuffer.putFloat(((value shr 16 and 0xFF) / 255.0f))
            byteBuffer.putFloat(((value shr 8 and 0xFF) / 255.0f))
            byteBuffer.putFloat(((value and 0xFF) / 255.0f))
        }
    }

    inputFeature0.loadBuffer(byteBuffer)

    // Jalankan model
    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer
    val confidences = outputFeature0.floatArray
    // Logging hasil confidence setiap kelas
    confidences.forEachIndexed { index, confidence ->
        Log.d("ML_OUTPUT", "Class $index: $confidence")
    }

    // Menentukan hasil dengan probabilitas tertinggi
    val maxIndex = confidences.indices.maxByOrNull { confidences[it] } ?: -1
    // Mengonversi confidence score ke persen
    val confidencePercentage = if (maxIndex != -1) (confidences[maxIndex] * 100).toInt() else 0

    // Logging hasil deteksi
    Log.d("ML_OUTPUT", "Predicted Class Index: $maxIndex")
    Log.d("ML_OUTPUT", "Confidence Score: ${confidences[maxIndex]}")
    val classLabels = arrayOf(
        "Angular Leaf Spot", "Bean Rust", "Healthy",
        "Leaf Crinkle","Powdery Mildew", "Yellow Mosaic"
    )
    val detectedClass = if (maxIndex in classLabels.indices) classLabels[maxIndex] else "Unknown"
    Log.d("ML_OUTPUT", "Detected Class: $detectedClass")
    model.close()

    return Pair(detectedClass, confidencePercentage)
}

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dekapan.R

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Tambahkan scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Kacang Panjang",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center // Teks rata kiri dan kanan
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "\tKacang panjang (Vigna unguiculata subsp. sesquipedalis), yang berasal dari Afrika, tumbuh dengan luas di seluruh Asia, termasuk Tenggara, China, Eropa, Oceania, dan Utara. Kacang panjang juga merupakan salah satu jenis sayuran yang banyak diperdagangkan di Indonesia. Pemanfaatannya sangat beragam, baik disajikan dalam keadaan mentah maupun dimasak dalam berbagai jenis hidangan. Prospek ekonomi kacang panjang terbilang menjanjikan di pasaran, sehingga budidaya kacang panjang untuk tujuan ekspor memiliki potensi yang cukup besar. Selain nilai ekonominya, kacang panjang juga dikenal sebagai sayuran yang kaya akan vitamin dan mineral. Kandungan nutrisinya berperan penting dalam mengatur metabolisme tubuh, meningkatkan kecerdasan, memperkuat daya tahan tubuh, serta memperlancar proses pencernaan berkat tingginya serat yang dimilikinya.",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify // Teks rata kiri dan kanan
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.picture2), // Ganti dengan gambar kamu
            contentDescription = "Home Image",
            modifier = Modifier
                .fillMaxWidth(0.6f) // Gambar menyesuaikan ukuran layar
                .aspectRatio(1f) // Memastikan proporsi tetap
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "\tKacang panjang memiliki berbagai manfaat yang beragam. Daun kacang panjang dapat membantu memperlancar produksi ASI pada ibu menyusui. Selain itu, kacang panjang mengandung senyawa fenolik yang lebih tinggi dibandingkan jenis kacang-kacangan lainnya, seperti buncis, kacang polong, kacang kedelai, kacang merah, dan kacang tunggak. Senyawa fenolik dalam kacang panjang berfungsi sebagai antioksidan yang mampu menangkal radikal bebas. Tidak hanya itu, mengonsumsi jus kacang panjang juga dapat membantu menurunkan kadar gula darah, sehingga bermanfaat bagi penderita diabetes mellitus.",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify // Teks rata kiri dan kanan
        )
    }
}

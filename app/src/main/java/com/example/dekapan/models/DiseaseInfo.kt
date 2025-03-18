package com.example.dekapan.models
import com.example.dekapan.R

class DiseaseInfo {
    companion object {
        private val diseaseDetails = mapOf(
            "Bean Rust" to "Disebabkan oleh jamur dari genus Uromyces dan ditandai dengan adanya bercak kecil berwarna putih pada permukaan daun kemudian bercak membesar dan berubah menjadi cokelat bertepung dikelilingi warna kuning atau bercincin cokelat. Akhirnya menjadi cokelat tua menyerupai karat pada besi.",
            "Angular Leaf Spot" to "Disebabkan oleh virus Bean Common Mosaic Virus(BCMV) dan ditandai dengan ditandai dengan daun yang belang, bercak kehitaman, bercak kuning yang menyebar, serta area hijau yang berkurang, di mana bentuk dan tekstur daun juga berbeda dari normal.",
            "Yellow Mosaic" to "Yellow mosaic diakibatkan oleh Mungbean Yellow Mosaic Virus (MYMV). yang menyerang tanaman kacang dan ditandai dengan munculnya bercak kuning yang tidak teratur pada daun, yang dapat menyebabkan daun menjadi keriput dan menguning secara keseluruhan.",
            "Powdery Mildew" to "Powdery mildew adalah penyakit yang disebabkan oleh jamur dari genus Levveillula taurica dan ditandai dengan munculnya lapisan putih seperti tepung pada permukaan daun, batang, dan bagian tanaman lainnya",
            "Leaf Crinkle" to "leaf crincle disebabkan oleh berbagai faktor, termasuk infeksi virus, hama, dan kondisi lingkungan yang tidak menguntungkan. Gejala yang umum terlihat adalah daun yang melengkung, keriput, dan pertumbuhan yang terhambat.",
            "Healthy" to "Tanaman sehat tidak menunjukkan tanda-tanda penyakit atau gangguan fisiologis, sehingga mampu mendukung proses fotosintesis dan pertumbuhan tanaman secara optimal."
        )

        private val solutionDetails = mapOf(
            "Bean Rust" to "Untuk mengendalikan penyakit ini, metode yang umum digunakan meliputi penanaman varietas tanaman kacang Panjang yang tahan akan penyakit, praktik rotasi tanaman untuk memutus siklus hidup patogen, serta aplikasi fungisida secara teratur, terutama pada awal musim tanam ketika tanaman masih rentan",
            "Angular Leaf Spot" to "Pengendalian penyakit ini lebih fokus pada pengendalian hama vektor, seperti kutu daun, yang dapat menyebarkan bakteri penyebab penyakit. Oleh karena itu, penggunaan insektisida untuk mengendalikan populasi hama sangat penting. Selain itu, praktik sanitasi yang baik, seperti membersihkan sisa-sisa tanaman yang terinfeksi dan menjaga kebersihan alat pertanian, juga berperan penting dalam mencegah penyebaran penyakit.",
            "Yellow Mosaic" to "Pengendalian penyakit ini dapat dilakukan dengan cara menanam varietas tanaman yang tahan terhadap MYMV, serta mengendalikan hama vektor seperti kutu daun yang dapat menyebarkan virus. Praktik sanitasi yang baik, seperti membersihkan sisa-sisa tanaman yang terinfeksi dan menjaga kebersihan alat pertanian, juga sangat penting untuk mencegah penyebaran penyakit ini.",
            "Powdery Mildew" to "Untuk mengendalikan embun tepung, penting untuk menjaga sirkulasi udara yang baik di antara tanaman, menghindari penyiraman yang berlebihan, dan menerapkan fungisida yang sesuai pada tahap awal infeksi. Selain itu, pemilihan varietas tanaman yang tahan terhadap embun tepung juga dapat membantu mengurangi risiko serangan.",
            "Leaf Crinkle" to "Pengendalian penyakit ini meliputi penggunaan varietas tahan, pengendalian hama vektor dengan insektisida, serta praktik sanitasi yang baik untuk mencegah penyebaran penyakit. Selain itu, menjaga kesehatan tanaman melalui pemupukan yang tepat dan pengelolaan air yang baik juga dapat membantu mencegah terjadinya penyakit daun keriting",
            "Healthy" to "Solusi yang dilakukan untuk mempertahankan tanaman agar tetap sehat adalah terus menjaga pola penyiraman, penggunaan  pupuk yang sesuai dengan jenis tanaman untuk memastikan kecukupan unsur hara, lakukan pengecekan secara rutin untuk mendeteksi gejala awal penyakit yang mungkin muncul, bersihkan lingkungan sekitar tanaman untuk mencegah serangan hama dan penyakit menggunakan pestisida alami atau hayati untuk menjaga tanaman tetap sehat."
        )

        fun getDiseaseDetail(disease: String): String {
            return diseaseDetails[disease] ?: "Penyakit tidak dikenali dalam database."
        }

        fun getSolutionDetail(disease: String): String {
            return solutionDetails[disease] ?: "Tidak ada solusi spesifik dalam database."
        }

        fun getDiseaseImage(disease: String): Int? {
            return when (disease) {
                "Bean Rust" -> R.mipmap.bean_rust
                "Angular Leaf Spot" -> R.mipmap.angular
                "Yellow Mosaic" -> R.mipmap.yellow
                "Powdery Mildew" -> R.mipmap.powdery
                "Leaf Crinkle" -> R.mipmap.crinckle
                "Healthy" -> R.mipmap.healthy
                else -> null
            }
        }
    }
}
package com.example.bootcamp // KENDİ PAKET ADINIZI BURAYA YAZIN

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.bootcamp.databinding.ActivityMainBinding // ViewBinding sınıfınız

// Data sınıflarınızın importları (eğer farklı bir paketteyse)
// import com.example.bootcamp.data.Movie
// import com.example.bootcamp.data.MovieCategory

// Adapter sınıflarınızın importları (eğer farklı bir paketteyse)
// import com.example.bootcamp.adapter.CategoryAdapter
// import com.example.bootcamp.adapter.MovieAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "onCreate çağrıldı.")

        setupUI()
        setupBottomNavigation()
    }

    private fun setupUI() {
        Log.d("MainActivity", "setupUI çağrıldı.")

        // Ana banner için resim
        Glide.with(this)
            .load(R.drawable.banner_main) // GERÇEK BANNER RESMİNİZ VARSA KULLANIN
            .placeholder(R.drawable.banner_main_placeholder) // Placeholder drawable'ınız
            .error(R.drawable.banner_main_placeholder) // Hata durumunda gösterilecek drawable
            .into(binding.imageViewMainBanner)
        Log.d("MainActivity", "Banner resmi yüklendi/yükleniyor.")


        val categories = getSampleMovieCategories()

        if (categories.isEmpty()) {
            Log.e("MainActivity", "Kategori listesi boş! RecyclerView için veri yok.")
            Toast.makeText(this, "Gösterilecek içerik bulunamadı.", Toast.LENGTH_LONG).show()
        } else {
            Log.d("MainActivity", "Kategori sayısı: ${categories.size}")
            categories.forEachIndexed { index, category ->
                Log.d("MainActivity", "Kategori[$index]: ${category.title}, Film sayısı: ${category.movies.size}")
                if (category.movies.isEmpty()) {
                    Log.w("MainActivity", "${category.title} kategorisinde film bulunmuyor.")
                }
            }
        }

        binding.recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity) // Dikey liste için
            adapter = CategoryAdapter(categories)
            Log.d("MainActivity", "recyclerViewCategories için LayoutManager ve Adapter ayarlandı.")
        }
    }

    private fun getSampleMovieCategories(): List<MovieCategory> {
        Log.d("MainActivity", "getSampleMovieCategories çağrıldı.")
        // Örnek veriler - drawable klasörünüzdeki resimlere göre R.drawable.isimleri güncelleyin
        // Eğer posterleriniz yoksa, hepsini R.drawable.poster_placeholder olarak ayarlayın.

        // Mevcut drawable'ları kontrol etmek için (opsiyonel, geliştirme aşamasında yardımcı olabilir)
        fun checkDrawable(resId: Int, name: String): Int {
            try {
                resources.getDrawable(resId, null) // Varlığını kontrol et
                // Log.d("MainActivity", "$name drawable bulundu.")
            } catch (e: Exception) {
                Log.e("MainActivity", "$name ($resId) drawable BULUNAMADI! Placeholder kullanılacak.")
                return R.drawable.poster_placeholder // Bulunamadıysa placeholder döndür
            }
            return resId
        }

        val popularMovies = listOf(
            Movie(1, "The Mandalorian", checkDrawable(R.drawable.poster_mandalorian, "poster_mandalorian")),
            Movie(2, "Loki", checkDrawable(R.drawable.poster_loki, "poster_loki")),
            Movie(3, "WandaVision", checkDrawable(R.drawable.poster_wandavision, "poster_wandavision")),
            Movie(4, "Hawkeye", checkDrawable(R.drawable.poster_hawkeye, "poster_hawkeye")),
            Movie(5, "Moon Knight", checkDrawable(R.drawable.poster_moonknight, "poster_moonknight"))
        )

        val newReleases = listOf(
            Movie(6, "Encanto", checkDrawable(R.drawable.poster_encanto, "poster_encanto")),
            Movie(7, "Luca", checkDrawable(R.drawable.poster_luca, "poster_luca")),
            Movie(8, "Turning Red", checkDrawable(R.drawable.poster_turning_red, "poster_turning_red")),
            Movie(9, "Lightyear", checkDrawable(R.drawable.poster_lightyear, "poster_lightyear"))
        )

        val marvelCollection = listOf(
            Movie(10, "Iron Man", checkDrawable(R.drawable.poster_ironman, "poster_ironman")),
            Movie(11, "Captain America", checkDrawable(R.drawable.poster_captain_america, "poster_captain_america")),
            Movie(2, "Loki", checkDrawable(R.drawable.poster_loki, "poster_loki")), // Tekrarlanan olabilir
            Movie(3, "WandaVision", checkDrawable(R.drawable.poster_wandavision, "poster_wandavision"))
        )

        val sampleCategories = listOf(
            MovieCategory("Popüler", popularMovies),
            MovieCategory("Yeni Eklenenler", newReleases),
            MovieCategory("Marvel Koleksiyonu", marvelCollection),
            MovieCategory("Sana Özel Öneriler", popularMovies.shuffled().take(if (popularMovies.size >=4) 4 else popularMovies.size)) // Karıştırılmış örnek, liste boyutu kontrolü
        )
        Log.d("MainActivity", "Örnek kategoriler oluşturuldu, sayı: ${sampleCategories.size}")
        return sampleCategories
    }

    private fun setupBottomNavigation() {
        Log.d("MainActivity", "setupBottomNavigation çağrıldı.")
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Zaten ana sayfada, bir şey yapmaya gerek yok veya sayfayı yenile
                    // Toast.makeText(this, "Ana Sayfa", Toast.LENGTH_SHORT).show()
                    Log.d("MainActivity", "BottomNav: Ana Sayfa tıklandı.")
                    true
                }
                R.id.navigation_search -> {
                    Toast.makeText(this, "Ara tıklandı", Toast.LENGTH_SHORT).show()
                    Log.d("MainActivity", "BottomNav: Ara tıklandı.")
                    true
                }
                R.id.navigation_downloads -> {
                    Toast.makeText(this, "İndirilenler tıklandı", Toast.LENGTH_SHORT).show()
                    Log.d("MainActivity", "BottomNav: İndirilenler tıklandı.")
                    true
                }
                R.id.navigation_profile -> {
                    Toast.makeText(this, "Profil tıklandı", Toast.LENGTH_SHORT).show()
                    Log.d("MainActivity", "BottomNav: Profil tıklandı.")
                    true
                }
                else -> {
                    Log.w("MainActivity", "BottomNav: Bilinmeyen item tıklandı - ${item.itemId}")
                    false
                }
            }
        }
        // Başlangıçta Ana Sayfa seçili olsun (eğer menüde varsa)
        if (binding.bottomNavigation.menu.findItem(R.id.navigation_home) != null) {
            binding.bottomNavigation.selectedItemId = R.id.navigation_home
            Log.d("MainActivity", "BottomNav: Ana Sayfa başlangıçta seçildi.")
        } else {
            Log.w("MainActivity", "BottomNav: navigation_home menüde bulunamadı.")
        }
    }
}

// Data Sınıfları (MainActivity ile aynı dosyada veya ayrı dosyalarda olabilir)
// Eğer ayrı dosyalardaysa, yukarıdaki importları kullanın.
// Eğer bu dosyada olacaksa, 'package' satırının altına koyun.
/*
data class Movie(
    val id: Int,
    val title: String,
    val posterResId: Int // Drawable resource ID
)

data class MovieCategory(
    val title: String,
    val movies: List<Movie>
)
*/
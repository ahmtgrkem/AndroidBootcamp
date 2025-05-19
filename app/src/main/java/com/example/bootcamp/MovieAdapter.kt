package com.example.bootcamp // KENDİ PAKET ADINIZI BURAYA YAZIN

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast // Tıklama sonrası basit bir mesaj için ekleyelim
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide // Glide importu
import com.example.bootcamp.databinding.ItemMovieBinding // ViewBinding importu - PAKET ADINIZI KONTROL EDİN

// Movie data sınıfınızın importu da burada olmalı,
// eğer farklı bir paketteyse:
// import com.example.bootcamp.Movie


class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            // XML'de imageViewMoviePoster ID'sinin olduğundan emin olun
            Glide.with(binding.root.context)
                .load(movie.posterResId) // Movie sınıfında posterResId olduğundan emin olun
                .placeholder(R.drawable.poster_placeholder) // Projenizde bu drawable olduğundan emin olun
                .error(R.drawable.poster_placeholder)
                .centerCrop()
                .into(binding.imageViewMoviePoster)

            // DetailActivity'yi kullanmayacağımız için tıklama olayını basitleştiriyoruz
            binding.root.setOnClickListener {
                // Örnek bir Toast mesajı gösterebiliriz
                Toast.makeText(binding.root.context, "${movie.title} tıklandı!", Toast.LENGTH_SHORT).show()

                // DetailActivity'ye yönlendirme kodu YORUM SATIRINA ALINDI veya SİLİNDİ:
                /*
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_MOVIE_TITLE, movie.title)
                    putExtra(DetailActivity.EXTRA_MOVIE_POSTER_RES_ID, movie.posterResId)
                }
                context.startActivity(intent)
                */
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}
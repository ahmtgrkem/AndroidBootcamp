package com.example.bootcamp // KENDİ PAKET ADINIZI BURAYA YAZIN

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager // LinearLayoutManager için import
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamp.databinding.ItemCategoryRowBinding // ViewBinding importu - PAKET ADINIZI KONTROL EDİN

// Movie ve MovieCategory data sınıflarınızın importları da burada olmalı,
// eğer farklı bir pakettelerse:
// import com.example.bootcamp.Movie
// import com.example.bootcamp.MovieCategory


class CategoryAdapter(private val categories: List<MovieCategory>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemCategoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: MovieCategory) {
            binding.textViewCategoryTitle.text = category.title // XML'de bu ID'nin olduğundan emin olun
            binding.recyclerViewMoviesHorizontal.apply { // XML'de bu ID'nin olduğundan emin olun
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = MovieAdapter(category.movies) // MovieAdapter'ın da doğru import edildiğinden emin olun
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}
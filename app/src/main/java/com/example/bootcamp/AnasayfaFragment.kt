package com.example.bootcamp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.bootcamp.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private var _binding: FragmentAnasayfaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        // Git -> A butonuna tıklama
        binding.buttonGitA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment2_to_AFragment)
        }

        // Git -> X butonuna tıklama
        binding.buttonGitX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment2_to_XFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
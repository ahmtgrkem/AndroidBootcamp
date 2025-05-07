package com.example.bootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bootcamp.databinding.FragmentBBinding

class BFragment : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        // Git -> Y butonuna tıklama
        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_BFragment_to_YFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
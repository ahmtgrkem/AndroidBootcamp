package com.example.bootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bootcamp.databinding.FragmentABinding

class AFragment : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)

        // Git -> B butonuna tıklama
        binding.buttonGitB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_AFragment_to_BFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
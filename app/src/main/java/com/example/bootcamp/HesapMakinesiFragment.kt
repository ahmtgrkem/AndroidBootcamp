package com.example.bootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bootcamp.databinding.FragmentHesapMakinesiBinding

class HesapMakinesiFragment : Fragment() {
    private var _binding: FragmentHesapMakinesiBinding? = null
    private val binding get() = _binding!!
    private var currentNumber = ""
    private var total = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHesapMakinesiBinding.inflate(inflater, container, false)

        // Sayı tuşlarına tıklama olayları
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )
        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                currentNumber += index.toString()
                binding.tvResult.text = currentNumber
            }
        }

        // Toplama tuşu
        binding.btnAdd.setOnClickListener {
            total += currentNumber.toIntOrNull() ?: 0
            currentNumber = ""
            binding.tvResult.text = total.toString()
        }

        // Sıfırlama tuşu
        binding.btnClear.setOnClickListener {
            currentNumber = ""
            total = 0
            binding.tvResult.text = "0"
        }

        binding.btnEquals.setOnClickListener {
            total += currentNumber.toIntOrNull() ?: 0
            currentNumber = ""
            binding.tvResult.text = total.toString()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
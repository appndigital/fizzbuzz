package com.appndigital.fizzbuzz.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.appndigital.fizzbuzz.databinding.FragmentFormBinding
import com.appndigital.fizzbuzz.ui.main.MainViewModel

/**
 * [Fragment] for getting user's values
 */
class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null

    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.defineFizzBuzz(binding.etInt1.text.toString().toIntOrNull() ?: 0, binding.etInt2.text.toString().toIntOrNull() ?: 0, binding.etLimit.text.toString().toIntOrNull() ?: 0, binding.etString1.text.toString(), binding.etString2.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
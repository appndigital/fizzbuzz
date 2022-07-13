package com.appndigital.fizzbuzz.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.appndigital.fizzbuzz.databinding.FragmentResultBinding
import com.appndigital.fizzbuzz.ui.main.MainViewModel
import com.appndigital.fizzbuzz.ui.main.adapter.FizzBuzzAdapter

/**
 * [Fragment] presenting result in a recyclerview
 */
class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: FizzBuzzAdapter

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBindings()
    }

    private fun setUpBindings(){
        viewModel.getCurrentFizzBuzz().value?.let {
            adapter = FizzBuzzAdapter(requireContext(), it)

            binding.rvResult.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            binding.rvResult.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
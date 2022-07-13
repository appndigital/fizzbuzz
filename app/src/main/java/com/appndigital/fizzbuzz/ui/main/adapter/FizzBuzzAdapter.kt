package com.appndigital.fizzbuzz.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appndigital.fizzbuzz.databinding.ItemFizzbuzzBinding
import com.appndigital.fizzbuzz.model.FizzBuzzDto
import com.appndigital.fizzbuzz.model.toString

/**
 * [RecyclerView.Adapter] presenting result
 */
class FizzBuzzAdapter(val context: Context, private var fizzBuzzDto: FizzBuzzDto): RecyclerView.Adapter<FizzBuzzHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FizzBuzzHolder {
        return FizzBuzzHolder(ItemFizzbuzzBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: FizzBuzzHolder, position: Int) {
        holder.binding.tvContent.text = fizzBuzzDto.toString(position + 1)
    }

    override fun getItemCount(): Int {
        return fizzBuzzDto.limit
    }
}

class FizzBuzzHolder(val binding: ItemFizzbuzzBinding) : RecyclerView.ViewHolder(binding.root)

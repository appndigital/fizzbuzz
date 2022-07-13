package com.appndigital.fizzbuzz.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appndigital.fizzbuzz.R
import com.appndigital.fizzbuzz.databinding.ActivityMainBinding
import com.appndigital.fizzbuzz.ui.main.fragment.FormFragment
import com.appndigital.fizzbuzz.ui.main.fragment.ResultFragment

/**
 * [AppCompatActivity] managing switch between fragments
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        showFragment(FormFragment(), R.id.fl_content)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        viewModel.getCurrentFizzBuzz().observe(this) {
            pushFragment(ResultFragment(), R.id.fl_content, "RESULT")
        }

    }

    private fun showFragment(fragment: Fragment, frameLayoutId: Int) {
        supportFragmentManager.beginTransaction().replace(frameLayoutId, fragment).commit()
    }

    private fun pushFragment(fragment: Fragment, frameLayoutId: Int, name: String?) {
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(frameLayoutId, fragment).addToBackStack(name).commit()
    }
}
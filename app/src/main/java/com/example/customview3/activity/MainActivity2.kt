package com.example.customview3.activity

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.customview3.R
import com.example.customview3.databinding.MainActivity2Binding

class MainActivity2 : AppCompatActivity() {
    var TAG = this.javaClass.simpleName
    lateinit var binding: MainActivity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.squareView.setOnClickListener {
            binding.squareView.swapColor()
        }
        binding.squareView.setOnLongClickListener {
            binding.squareView.isEnabled = true

            binding.squareView.setRandomColor()
            return@setOnLongClickListener false
        }
//        binding.squareView.setOnTouchListener { v, event ->
//            if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL) {
//                binding.squareView.isEnabled = false
//            }
//            Log.d(TAG, event.action.toString())
//            return@setOnTouchListener super.onTouchEvent(event)
//        }


    }
}
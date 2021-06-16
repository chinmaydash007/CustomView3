package com.example.customview3.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.customview3.R
import com.example.customview3.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)


        val defaultRatio = (binding.seekbar.progress.toFloat() / binding.seekbar.max.toFloat())
        binding.myView.setShapeRadiusRatio(defaultRatio, binding.seekbar.progress)



        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val defaultRatio = (binding.seekbar.getProgress().toFloat()
                        / binding.seekbar.getMax().toFloat())
                binding.myView.setShapeRadiusRatio(defaultRatio, progress)
                binding.myView.invalidate()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        binding.button.setOnClickListener {

            val animator: ValueAnimator = ValueAnimator()
            animator.setDuration(1000)
            animator.addUpdateListener {
                binding.myView.setShapeRadiusRatio(animator.animatedFraction, 0)
                binding.myView.invalidate()
            }
        }

//        val valueSelector = findViewById<View>(R.id.valueSelector) as ValueSelector
//        valueSelector.minValue = 0
//        valueSelector.maxValue = 100
//
//        val valueBar = findViewById<View>(R.id.valueBar) as ValueBar
//        valueBar.setMaxValue(100)
//        valueBar.setAnimated(true)
//        valueBar.setAnimationDuration(4000L)

//        val updateButton: Button = findViewById<View>(R.id.updateButton) as Button
//        updateButton.setOnClickListener(object : OnClickListener() {
//            fun onClick(view: View?) {
//                val value = valueSelector.value
//                valueBar.value = value
//
//                //code to use Object Animation instead of the built-in ValueBar animation
//                //if you use this, be sure the call valueBar.setAnimated(false);
//                /*
//                ObjectAnimator anim = ObjectAnimator.ofInt(valueBar, "value", valueBar.getValue(), value);
//                anim.setDuration(1000);
//                anim.start();
//                */
//            }
//        })


    }
}
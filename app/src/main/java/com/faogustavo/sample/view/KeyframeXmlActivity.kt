package com.faogustavo.sample.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.R
import com.faogustavo.sample.databinding.KeyframeMainBinding

class KeyframeXmlActivity : AppCompatActivity() {

    private var isShowing = true
    lateinit var binding: KeyframeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<KeyframeMainBinding>(this, R.layout.keyframe_main)

        setTitle("Keyframe XML animation")

        binding.backgroundImage.setOnClickListener {
            if (isShowing) {
                hide()
            } else {
                show()
            }
        }
    }

    private fun show() {
        isShowing = true
        binding.root.modify(R.layout.keyframe_main) {
            animated()
        }
    }

    private fun hide() {
        isShowing = false
        binding.root.modify(R.layout.keyframe_alternative){
            animated()
        }
    }

}
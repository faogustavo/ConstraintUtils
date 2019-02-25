package com.faogustavo.sample.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.faogustavo.sample.R
import com.faogustavo.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.keyframe.setOnClickListener { startActivity(KeyframeXmlActivity::class.java) }
        binding.keyframe2.setOnClickListener { startActivity(KeyframeProgrammaticallyActivity::class.java) }
        binding.sizes.setOnClickListener { startActivity(SizesActivity::class.java) }
        binding.rotationBias.setOnClickListener { startActivity(RotationBiasActivity::class.java) }
        binding.circular.setOnClickListener { startActivity(CircleFabActivity::class.java) }
        binding.fullProgrammatically.setOnClickListener { startActivity(OrionProgramaticallyActivity::class.java) }
    }

    fun <T> startActivity(clazz: Class<T>) {
        startActivity(Intent(this, clazz))
    }
}

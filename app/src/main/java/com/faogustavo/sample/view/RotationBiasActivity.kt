package com.faogustavo.sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.R
import com.faogustavo.sample.databinding.ActivityRotationBiasBinding

class RotationBiasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRotationBiasBinding

    private var hBiasPosition = 1
    private var vBiasPosition = 0
    private var rotation = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rotation_bias)
        binding.horizontalBiasButton.setOnClickListener { changeHBias() }
        binding.verticalBiasButton.setOnClickListener { changeVBias() }
        binding.rotationButton.setOnClickListener { changeRotation() }
    }

    private fun changeHBias() {
        with(binding) {
            root.modify {
                on(horizontalBiasButton) {
                    horizontalBias(when(hBiasPosition % 3) {
                        0 -> 0f
                        1 -> 0.5f
                        2 -> 1f
                        else -> 0.5f
                    })
                }

                animated()
            }
        }
        hBiasPosition++
    }

    private fun changeVBias() {
        with(binding) {
            root.modify {
                on(verticalBiasButton) {
                    verticalBias(when(vBiasPosition % 3) {
                        0 -> 0f
                        1 -> 0.5f
                        2 -> 1f
                        else -> 0.5f
                    })
                }

                animated()
            }
        }
        vBiasPosition++
    }

    private fun changeRotation() {
        rotation += 30
        with(binding) {
            root.modify {
                on(rotationButton) {
                    rotation(rotation % 360f)
                }

                animated()
            }
        }
    }

}
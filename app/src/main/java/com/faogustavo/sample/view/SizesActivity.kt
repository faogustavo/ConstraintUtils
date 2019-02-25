package com.faogustavo.sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.R
import com.faogustavo.sample.databinding.ActivitySizesBinding
import com.faogustavo.sample.toolkit.dp

class SizesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySizesBinding

    private var isAltWidth = false
    private var isAltHeight = false
    private var isAltRatio = false
    private var isMinWidth = false
    private var isMaxWidth = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sizes)

        setTitle("Working with sizes")

        binding.width.setOnClickListener { onWidth() }
        binding.height.setOnClickListener { onHeight() }
        binding.ratio.setOnClickListener { onRatio() }
        binding.minWidth.setOnClickListener { onMinWidth() }
        binding.maxWidth.setOnClickListener { onMaxWidth() }
    }

    private fun onWidth() {
        with(binding) {
            root.modify {
                on(width) {
                    width(if (isAltWidth) 100.dp else 150.dp)
                }

                animated()
            }
        }

        isAltWidth = !isAltWidth
    }

    private fun onHeight() {
        with(binding) {
            root.modify {
                on(height) {
                    height(if (isAltHeight) 80.dp else 130.dp)
                }

                animated()
            }
        }

        isAltHeight = !isAltHeight
    }

    private fun onRatio() {
        with(binding) {
            root.modify {
                on(ratio) {
                    setRatio(if (isAltRatio) "4:3" else "16:9")
                }

                animated()
            }
        }

        isAltRatio = !isAltRatio
    }

    private fun onMinWidth() {
        isMinWidth = !isMinWidth
        with(binding) {
            root.modify {
                on(minWidth) {
                    if (isMinWidth) {
                        minWidth(200.dp)
                    } else {
                        widthWrapContent()
                    }
                }

                animated()
            }
        }
    }

    private fun onMaxWidth() {
        isMaxWidth = !isMaxWidth
        with(binding) {
            root.modify {
                on(maxWidth) {
                    if (isMaxWidth) {
                        maxWidth(200.dp)
                    } else {
                        widthWrapContent()
                    }
                }

                animated()
            }
        }
    }

}
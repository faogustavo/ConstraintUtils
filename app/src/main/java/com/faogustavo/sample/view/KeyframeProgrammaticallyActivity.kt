package com.faogustavo.sample.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.faogustavo.constraint.utils.ConstraintViewEditor
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.R
import com.faogustavo.sample.databinding.KeyframeMainBinding
import com.faogustavo.sample.toolkit.dp

class KeyframeProgrammaticallyActivity : AppCompatActivity() {

    private var isShowing = true
    lateinit var binding: KeyframeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<KeyframeMainBinding>(this, R.layout.keyframe_main)

        setTitle("Keyframe programmatically animation")

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
        with(binding) {
            root.modify {
                on(backgroundImage) {
                    bottomToBottomOf(this.parent)
                }

                on(title) {
                    unbind(ConstraintViewEditor.Side.LEFT)
                    rightToLeftOf(this.parent, 16.dp)
                }

                on(description) {
                    unbind(ConstraintViewEditor.Side.BOTTOM)
                    topToBottomOf(this.parent)
                }

                animated()
            }
        }
    }

}
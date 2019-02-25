package com.faogustavo.sample.view

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.R
import com.faogustavo.sample.toolkit.dp
import com.faogustavo.sample.toolkit.setAnimatedIconDrawable
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CircleFabActivity : AppCompatActivity() {

    private val root by lazy {
        ConstraintLayout(this).apply {
            id = View.generateViewId()
        }
    }

    private val rootButton by lazy {
        FloatingActionButton(this).apply {
            id = View.generateViewId()
            setImageResource(R.drawable.ic_share)
            size = FloatingActionButton.SIZE_NORMAL
        }
    }

    private val miniButtons by lazy {
        listOf(R.drawable.ic_facebook, R.drawable.ic_google_plus, R.drawable.ic_linkedin, R.drawable.ic_twitter).map {
            generateButton(it)
        }
    }

    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(root)

        miniButtons.forEach {
            root.addView(it)
            it.setOnClickListener { }
        }
        root.addView(rootButton)

        root.modify {
            on(rootButton) {
                bottomToBottomOf(parent, 32.dp)
                rightToRightOf(parent, 32.dp)
                setElevation(5.dp.toFloat())

                centerCircleTo(miniButtons, 0, 245, 15)
            }

            miniButtons.forEach {
                on(it) {
                    alignVerticalWith(rootButton)
                    alignHorizontalWith(rootButton)
                    setElevation(1.dp.toFloat())
                }
            }
        }

        rootButton.setOnClickListener { handleClick() }
    }

    private fun generateButton(@DrawableRes icon: Int) = FloatingActionButton(this).apply {
        id = View.generateViewId()
        setImageResource(icon)
        size = FloatingActionButton.SIZE_MINI
    }

    private fun handleClick() {
        root.modify {
            on(rootButton) {
                centerCircleTo(miniButtons, if (isExpanded) 0 else 92.dp, 230, 30)
                rootButton.setAnimatedIconDrawable(if (isExpanded) R.drawable.close_to_share else R.drawable.share_to_close)
            }

            animated()
        }

        isExpanded = !isExpanded
    }

}
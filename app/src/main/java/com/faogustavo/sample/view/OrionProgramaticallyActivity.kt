package com.faogustavo.sample.view

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.faogustavo.sample.R
import com.faogustavo.constraint.utils.modify
import com.faogustavo.sample.toolkit.dp

class OrionProgramaticallyActivity : AppCompatActivity() {

    private val root by lazy {
        ConstraintLayout(this).apply {
            id = View.generateViewId()
        }
    }

    private val background by lazy {
        ImageView(this).apply {
            id = View.generateViewId()
            setImageResource(R.drawable.background)
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
    }

    private val title by lazy {
        TextView(this).apply {
            id = View.generateViewId()
            text = "Orion M42"
            setTextColor(Color.parseColor("#FFFFFF"))
            setBackgroundColor(Color.parseColor("#008577"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 48f)
            setPadding(24.dp, 0, 24.dp, 0)
        }
    }

    private val subtitle by lazy {
        TextView(this).apply {
            id = View.generateViewId()
            text = "Bryan Goff on Unsplash"
            setBackgroundColor(Color.parseColor("#d3d3d3"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            setPadding(16.dp, 4.dp, 16.dp, 4.dp)
        }
    }

    private val description by lazy {
        TextView(this).apply {
            id = View.generateViewId()
            text =
                "The Orion Nebula, or M42, is one of the brigtest nebula from earth. With the naked eye you can sometimes see orion as the middle star in the \"sword\" of the Orion constelation"
            setTextColor(Color.parseColor("#FFFFFF"))
            setBackgroundColor(Color.parseColor("#181818"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            setPadding(8.dp, 0, 8.dp, 8.dp)
        }
    }

    private val gradient by lazy {
        View(this).apply {
            id = View.generateViewId()
            background = ContextCompat.getDrawable(this@OrionProgramaticallyActivity, R.drawable.gradient)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(root)

        setTitle("Layout with just kotlin")

        root.addView(background)
        root.addView(title)
        root.addView(subtitle)
        root.addView(description)
        root.addView(gradient)

        root.modify {
            on(background) {
                parentWidth()
                parentHeight()
            }

            on(title) {
                topToTopOf(parent, 24.dp)
                leftToLeftOf(parent)
            }

            on(subtitle) {
                rightToRightOf(title)
                topToBottomOf(title)
            }

            on(description) {
                parentWidth()
                bottomToBottomOf(parent)
            }

            on(gradient) {
                height(30.dp)
                parentWidth()
                bottomToTopOf(description)
            }
        }
    }

}
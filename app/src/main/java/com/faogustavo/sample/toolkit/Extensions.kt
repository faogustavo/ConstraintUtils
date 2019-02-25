package com.faogustavo.sample.toolkit

import android.content.res.Resources
import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.google.android.material.floatingactionbutton.FloatingActionButton

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

fun FloatingActionButton.setAnimatedIconDrawable(@DrawableRes drawableId: Int): AnimatedVectorDrawable {
    val drawable = context?.getDrawable(drawableId) as AnimatedVectorDrawable

    setImageDrawable(drawable)
    drawable.start()

    return drawable
}
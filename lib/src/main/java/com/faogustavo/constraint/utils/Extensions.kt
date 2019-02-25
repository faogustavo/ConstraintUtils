package com.faogustavo.constraint.utils

import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.modify(block: ConstraintEditor.() -> Unit) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    ConstraintEditor(this, constraintSet).apply(block)
    constraintSet.applyTo(this)
}

fun ConstraintLayout.modify(@LayoutRes layoutId: Int, block: ConstraintEditor.() -> Unit = {}) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(context, layoutId)
    ConstraintEditor(this, constraintSet).apply(block)
    constraintSet.applyTo(this)
}

fun Int.rangeCircular(to: Int, maxValue: Int, itemCount: Int): List<Int> {
    val max = if (this < to) to else maxValue + to
    val step = (max - this) / (itemCount + 1)

    val values = mutableListOf<Int>()
    for (i in 1..itemCount) {
        values.add((this + (i * step)) % maxValue)
    }

    return values
}
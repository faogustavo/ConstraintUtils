package com.faogustavo.constraint.utils

import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.modify(block: ConstraintEditor.() -> Unit) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    ConstraintEditor(constraintSet).apply(block)
    constraintSet.applyTo(this)
}

fun ConstraintLayout.modify(@LayoutRes layoutId: Int, block: ConstraintEditor.() -> Unit = {}) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(context, layoutId)
    ConstraintEditor(constraintSet).apply(block)
    constraintSet.applyTo(this)
}
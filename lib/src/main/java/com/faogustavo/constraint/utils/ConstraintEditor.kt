package com.faogustavo.constraint.utils

import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintEditor(private val set: ConstraintSet) {

    fun on(view: View, block: ConstraintViewEditor.() -> Unit) {
        on(view.id, block)
    }

    fun on(id: Int, block: ConstraintViewEditor.() -> Unit) {
        ConstraintViewEditor(set, id).apply(block)
    }

}
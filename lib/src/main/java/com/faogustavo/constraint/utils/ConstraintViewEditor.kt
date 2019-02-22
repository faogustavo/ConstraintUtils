package com.faogustavo.constraint.utils

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintViewEditor(private val set: ConstraintSet, private val viewId: Int) {

    fun topToTopOf(view: View, margin: Int = 0) {
        topToTopOf(view.id, margin)
    }

    fun topToBottomOf(view: View, margin: Int = 0) {
        topToBottomOf(view.id, margin)
    }

    fun bottomToBottomOf(view: View, margin: Int = 0) {
        bottomToBottomOf(view.id, margin)
    }

    fun bottomToTopOf(view: View, margin: Int = 0) {
        bottomToTopOf(view.id, margin)
    }

    fun leftToLeftOf(view: View, margin: Int = 0) {
        leftToLeftOf(view.id, margin)
    }

    fun leftToRightOf(view: View, margin: Int = 0) {
        leftToRightOf(view.id, margin)
    }

    fun rightToRightOf(view: View, margin: Int = 0) {
        rightToRightOf(view.id, margin)
    }

    fun rightToLeftOf(view: View, margin: Int = 0) {
        rightToLeftOf(view.id, margin)
    }

    fun topToTopOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.TOP, id, ConstraintSet.TOP, margin)
    }

    fun topToBottomOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.TOP, id, ConstraintSet.BOTTOM, margin)
    }

    fun bottomToBottomOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.BOTTOM, id, ConstraintSet.BOTTOM, margin)
    }

    fun bottomToTopOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.BOTTOM, id, ConstraintSet.TOP, margin)
    }

    fun leftToLeftOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.LEFT, id, ConstraintSet.LEFT, margin)
    }

    fun leftToRightOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.LEFT, id, ConstraintSet.RIGHT, margin)
    }

    fun rightToRightOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.RIGHT, id, ConstraintSet.RIGHT, margin)
    }

    fun rightToLeftOf(id: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.RIGHT, id, ConstraintSet.LEFT, margin)
    }

}
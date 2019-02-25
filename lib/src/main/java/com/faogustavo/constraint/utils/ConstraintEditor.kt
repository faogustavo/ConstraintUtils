package com.faogustavo.constraint.utils

import android.transition.*
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintEditor(private val layout: ConstraintLayout, private val set: ConstraintSet) {

    companion object {
        private val DEFAULT_TRANSITION = TransitionSet().apply {
            this.addTransition(Explode())
            this.addTransition(ChangeBounds())
            this.addTransition(ChangeTransform())
            this.addTransition(ChangeClipBounds())
        }
    }

    fun animated() {
        withTransition(DEFAULT_TRANSITION)
    }

    fun withTransition(transition: Transition) {
        TransitionManager.beginDelayedTransition(layout, transition)
    }

    fun on(view: View, block: ConstraintViewEditor.() -> Unit) {
        on(view.id, block)
    }

    fun on(id: Int, block: ConstraintViewEditor.() -> Unit) {
        ConstraintViewEditor(set, layout.id, id).apply(block)
    }

}
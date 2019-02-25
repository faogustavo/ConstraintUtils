package com.faogustavo.constraint.utils

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintViewEditor(private val set: ConstraintSet, val parent: Int, private val viewId: Int) {

    enum class Side {
        ALL, LEFT, RIGHT, TOP, BOTTOM
    }

    fun unbind(side: Side) {
        when (side) {
            Side.ALL -> set.clear(viewId)
            Side.LEFT -> set.clear(viewId, ConstraintSet.LEFT)
            Side.RIGHT -> set.clear(viewId, ConstraintSet.RIGHT)
            Side.TOP -> set.clear(viewId, ConstraintSet.TOP)
            Side.BOTTOM -> set.clear(viewId, ConstraintSet.BOTTOM)
        }
    }

    fun topToTopOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.TOP, anotherId, ConstraintSet.TOP, margin)
    }

    fun topToBottomOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.TOP, anotherId, ConstraintSet.BOTTOM, margin)
    }

    fun bottomToBottomOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.BOTTOM, anotherId, ConstraintSet.BOTTOM, margin)
    }

    fun bottomToTopOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.BOTTOM, anotherId, ConstraintSet.TOP, margin)
    }

    fun leftToLeftOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.LEFT, anotherId, ConstraintSet.LEFT, margin)
    }

    fun leftToRightOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.LEFT, anotherId, ConstraintSet.RIGHT, margin)
    }

    fun rightToRightOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.RIGHT, anotherId, ConstraintSet.RIGHT, margin)
    }

    fun rightToLeftOf(anotherId: Int, margin: Int = 0) {
        set.connect(viewId, ConstraintSet.RIGHT, anotherId, ConstraintSet.LEFT, margin)
    }

    fun centerCircleWithIdTo(anothersViews: List<Int>, radius: Int, rangeInitial: Int, rangeFinal: Int) {
        val angleRange = rangeInitial.rangeCircular(rangeFinal, 360, anothersViews.size)
        anothersViews.forEachIndexed { index, item ->
            set.constrainCircle(item, viewId, radius, angleRange[index].toFloat())
        }
    }

    fun circleTo(anotherId: Int, angle: Float, radius: Int) {
        set.constrainCircle(viewId, anotherId, radius, angle)
    }

    fun alignVerticalWith(anotherId: Int) {
        topToTopOf(anotherId)
        bottomToBottomOf(anotherId)
    }

    fun alignHorizontalWith(anotherId: Int) {
        rightToRightOf(anotherId)
        leftToLeftOf(anotherId)
    }

    fun parentWidth() {
        rightToRightOf(parent)
        leftToLeftOf(parent)
        widthMatchConstraint()
    }

    fun parentHeight() {
        topToTopOf(parent)
        bottomToBottomOf(parent)
        heightMatchConstraint()
    }

    fun width(width: Int) {
        set.constrainWidth(viewId, width)
    }

    fun height(height: Int) {
        set.constrainHeight(viewId, height)
    }

    fun widthMatchConstraint() {
        set.constrainWidth(viewId, ConstraintSet.MATCH_CONSTRAINT)
    }

    fun heightMatchConstraint() {
        set.constrainHeight(viewId, ConstraintSet.MATCH_CONSTRAINT)
    }

    fun widthWrapContent() {
        set.constrainWidth(viewId, ConstraintSet.WRAP_CONTENT)
    }

    fun heightWrapContent() {
        set.constrainHeight(viewId, ConstraintSet.WRAP_CONTENT)
    }

    fun minWidth(width: Int) {
        widthMatchConstraint()
        set.constrainMinWidth(viewId, width)
    }

    fun minHeight(height: Int) {
        heightMatchConstraint()
        set.constrainMinHeight(viewId, height)
    }

    fun maxWidth(width: Int) {
        widthMatchConstraint()
        set.constrainMaxWidth(viewId, width)
    }

    fun maxHeight(height: Int) {
        heightMatchConstraint()
        set.constrainMaxHeight(viewId, height)
    }

    fun rotation(rotation: Float) {
        set.setRotation(viewId, rotation)
    }

    fun verticalBias(bias: Float) {
        set.setVerticalBias(viewId, bias)
    }

    fun horizontalBias(bias: Float) {
        set.setHorizontalBias(viewId, bias)
    }

    fun setRatio(ratio: String) {
        set.setDimensionRatio(viewId, ratio)
    }

    fun setElevation(elevation: Float) {
        set.setElevation(viewId, elevation)
    }

    // region Aliases with view as parameter
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

    fun alignVerticalWith(view: View) {
        alignVerticalWith(view.id)
    }

    fun alignHorizontalWith(view: View) {
        alignHorizontalWith(view.id)
    }

    fun centerCircleTo(anothersViews: List<View>, radius: Int, rangeInitial: Int, rangeFinal: Int) {
        centerCircleWithIdTo(anothersViews.map { it.id }, radius, rangeInitial, rangeFinal)
    }
    // endregion

}
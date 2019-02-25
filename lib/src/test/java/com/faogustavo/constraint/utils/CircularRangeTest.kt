package com.faogustavo.constraint.utils

import org.junit.Test

class CircularRangeTest {

    companion object {
        const val MAX_VALUE = 360
    }

    @Test
    fun rangeCircular_withOrderedItems_withOneItems() {
        val initial = 0
        val final = 90
        val itemCount = 1

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 1)
        assert(result[0] == 45)
    }

    @Test
    fun rangeCircular_withOrderedItems_withTwoItems() {
        val initial = 0
        val final = 90
        val itemCount = 2

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 2)
        assert(result[0] == 30)
        assert(result[1] == 60)
    }

    @Test
    fun rangeCircular_withOrderedItems_withFiveItems() {
        val initial = 0
        val final = 90
        val itemCount = 5

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 5)
        assert(result[0] == 15)
        assert(result[1] == 30)
        assert(result[2] == 45)
        assert(result[3] == 60)
        assert(result[4] == 75)
    }

    @Test
    fun rangeCircular_withUnorderedItems_withOneItems() {
        val initial = 270
        val final = 90
        val itemCount = 1

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 1)
        assert(result[0] == 0)
    }

    @Test
    fun rangeCircular_withUnorderedItems_withTwoItems() {
        val initial = 270
        val final = 90
        val itemCount = 2

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 2)
        assert(result[0] == 330)
        assert(result[1] == 30)
    }

    @Test
    fun rangeCircular_withUnorderedItems_withFiveItems() {
        val initial = 270
        val final = 90
        val itemCount = 5

        val result = initial.rangeCircular(final, MAX_VALUE, itemCount)
        assert(result.size == 5)
        assert(result[0] == 300)
        assert(result[1] == 330)
        assert(result[2] == 0)
        assert(result[3] == 30)
        assert(result[4] == 60)
    }

}
package com.haitrvn.core

import kotlin.test.Test
import kotlin.test.assertEquals

class RoundTest {

    @Test
    fun double_round_zero() {
        assertEquals(0.0, 0.0.round(2), 0.0)
    }

    @Test
    fun double_round_positive_no_decimal() {
        assertEquals(123.0, 123.0.round(2), 0.0)
    }

    @Test
    fun double_round_positive_less_than_scale() {
        assertEquals(123.4, 123.4.round(2), 0.0)
    }

    @Test
    fun double_round_positive_equal_to_scale() {
        assertEquals(123.45, 123.45.round(2), 0.0)
    }

    @Test
    fun double_round_positive_greater_than_scale_round_down() {
        assertEquals(123.45, 123.454.round(2), 0.0)
    }

    @Test
    fun double_round_positive_greater_than_scale_round_up() {
        assertEquals(123.46, 123.456.round(2), 0.0)
    }

    @Test
    fun double_round_positive_greater_than_scale_round_half_up() {
        assertEquals(123.46, 123.455.round(2), 0.0)
    }

    @Test
    fun double_round_negative_no_decimal() {
        assertEquals(-123.0, (-123.0).round(2), 0.0)
    }

    @Test
    fun double_round_negative_greater_than_scale_round_down() {
        assertEquals(-123.45, (-123.454).round(2), 0.0)
    }

    @Test
    fun double_round_negative_greater_than_scale_round_up() {
        assertEquals(-123.46, (-123.456).round(2), 0.0)
    }

    @Test
    fun float_round_zero() {
        assertEquals(0.0f, 0.0f.round(2), 0.0f)
    }

    @Test
    fun float_round_positive_no_decimal() {
        assertEquals(123.0f, 123.0f.round(2), 0.0f)
    }

    @Test
    fun float_round_positive_greater_than_scale_round_down() {
        assertEquals(123.45f, 123.454f.round(2), 0.0f)
    }

    @Test
    fun float_round_positive_greater_than_scale_round_up() {
        assertEquals(123.46f, 123.456f.round(2), 0.0f)
    }
}
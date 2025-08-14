package com.haitrvn.core

import kotlin.math.pow
import kotlin.math.roundToInt

// Extension cho Double
fun Double.round(decimals: Int): Double {
    val factor = 10.0.pow(decimals)
    return (this * factor).roundToInt() / factor
}

// Extension cho Float
fun Float.round(decimals: Int): Float {
    val factor = 10f.pow(decimals)
    return (this * factor).roundToInt() / factor
}
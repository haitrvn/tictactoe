package com.haitrvn.splash

import androidx.compose.ui.geometry.Rect

data class CornerRect(
    val centerX: Float,
    val centerY: Float,
    val width: Float,
    val height: Float,
    val startAngel: Float,
    val sweepAngle: Float,
) {
    fun toRect(): Rect = Rect(
        left = centerX - width / 2f,
        top = centerY - height / 2f,
        right = centerX + width / 2f,
        bottom = centerY + height / 2f
    )
}

enum class Direction {
    TOP, BOTTOM, START, END
}

fun topRect(

): List<CornerRect> {

    return emptyList()
}

fun createRects(
    canvasWidth: Float,
    canvasHeight: Float,
    cornerRectSize: Float,
    padding: Float,
    offset: Float,
): List<CornerRect> {
    val halfRectSize = cornerRectSize / 2f
    val leftWithOffset = padding + halfRectSize
    val rightWithOffset = canvasWidth - padding - halfRectSize - cornerRectSize
    val topWithOffset = padding + halfRectSize
    val bottomWithOffset = canvasHeight - padding - halfRectSize

    val maxOffSetSize = offset.coerceAtMost(cornerRectSize)
    val rectList = mutableListOf(
        CornerRect(
            centerX = canvasWidth - padding - cornerRectSize - offset.coerceAtMost(cornerRectSize) / 2,
            centerY = padding + offset.coerceAtMost(cornerRectSize) / 2,
            width = offset.coerceAtMost(cornerRectSize),
            height = offset.coerceAtMost(cornerRectSize),
            startAngel = 0f,
            sweepAngle = 90f,
        ),  // bottom-right
        CornerRect(
            centerX = canvasWidth - padding - cornerRectSize + offset.coerceAtMost(halfRectSize) / 2,
            centerY = padding + maxOffSetSize + offset.coerceAtMost(halfRectSize) / 2,
            width = offset.coerceAtMost(halfRectSize),
            height = offset.coerceAtMost(halfRectSize),
            startAngel = 270f,
            sweepAngle = 90f,
        ), //1
        CornerRect(
            centerX = rightWithOffset + cornerRectSize,
            centerY = padding + halfRectSize + offset.coerceAtMost(cornerRectSize) + offset.coerceAtMost(
                halfRectSize
            ),
            width = cornerRectSize,
            height = cornerRectSize,
            startAngel = 270f,
            sweepAngle = 90f,
        ),//2
        CornerRect(
            centerX = rightWithOffset,
            centerY = bottomWithOffset,
            width = cornerRectSize,
            height = cornerRectSize,
            startAngel = 0f,
            sweepAngle = 90f,
        ),  // bottom-right
        CornerRect(
            centerX = leftWithOffset,
            centerY = bottomWithOffset,
            width = cornerRectSize,
            height = cornerRectSize,
            startAngel = 90f,
            sweepAngle = 90f,
        ), // bottom-left
        CornerRect(
            centerX = leftWithOffset,
            centerY = topWithOffset,
            width = cornerRectSize,
            height = cornerRectSize,
            startAngel = 180f,
            sweepAngle = 90f,
        ), // top-left
    )
    return rectList
}

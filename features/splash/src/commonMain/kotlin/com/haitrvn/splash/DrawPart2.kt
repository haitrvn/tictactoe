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
    val maxSmallRectSize = offset.coerceAtMost(maxOffSetSize / 2)
    val rectList = mutableListOf(
        CornerRect(
            centerX = rightWithOffset + cornerRectSize / 2 - maxOffSetSize / 2,
            centerY = topWithOffset - cornerRectSize / 2 + maxOffSetSize / 2,
            width = maxOffSetSize,
            height = maxOffSetSize,
            startAngel = 270f,
            sweepAngle = 90f,
        ), // top-right
        CornerRect(
            centerX = (rightWithOffset + cornerRectSize / 2 - maxOffSetSize / 2) - maxOffSetSize / 2 + maxSmallRectSize / 2 + maxOffSetSize,
            centerY = (topWithOffset - cornerRectSize / 2 + maxOffSetSize / 2) - maxOffSetSize / 2 + maxSmallRectSize / 2 + maxOffSetSize,
            width = maxSmallRectSize,
            height = maxSmallRectSize,
            startAngel = 180f,
            sweepAngle = -90f,
        ),
        CornerRect(
            centerX = rightWithOffset + cornerRectSize,
            centerY = topWithOffset + +maxOffSetSize + maxSmallRectSize,
            width = cornerRectSize,
            height = cornerRectSize,
            startAngel = 270f,
            sweepAngle = 180f,
        ),
        CornerRect(
            centerX = (rightWithOffset + cornerRectSize / 2 - maxOffSetSize / 2) - maxOffSetSize / 2 + maxSmallRectSize / 2 + maxOffSetSize,
            centerY = (topWithOffset - cornerRectSize / 2 + maxOffSetSize / 2) - maxOffSetSize / 2 + maxSmallRectSize / 2 + maxOffSetSize + cornerRectSize + maxSmallRectSize,
            width = maxSmallRectSize,
            height = maxSmallRectSize,
            startAngel = 270f,
            sweepAngle = -90f,
        ),
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

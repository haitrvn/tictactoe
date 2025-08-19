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

    val maxOffSetSize = offset.coerceAtMost(cornerRectSize / 2)

    val rectList = mutableListOf(
        CornerRect(
            centerX = rightWithOffset + halfRectSize / 2 + maxOffSetSize / 2,
            centerY = topWithOffset - halfRectSize / 2 - maxOffSetSize / 2,
            width = offset.coerceAtMost(maxOffSetSize),
            height = offset.coerceAtMost(maxOffSetSize),
            startAngel = 270f,
            sweepAngle = 90f,
        ), // top-right
//        CornerRect(
//            centerX = rightWithOffset + halfRectSize + (offset / 4f).coerceAtMost(cornerRectSize / 2),
//            centerY = padding + (offset * 3f / 4f).coerceAtMost(cornerRectSize / 2),
//            width = (offset / 2).coerceAtMost(cornerRectSize),
//            height = (offset / 2).coerceAtMost(cornerRectSize),
//            startAngel = 180f,
//            sweepAngle = -90f,
//        ),  // small first
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

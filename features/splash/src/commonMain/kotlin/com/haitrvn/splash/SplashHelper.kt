package com.haitrvn.splash

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DrawPosition(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val startAngel: Float,
    val sweepAngel: Float,
)

fun DrawPosition.toRect() {
    Rect(x - width / 2, y - height / 2, x + width / 2, y + height / 2)
}

fun Modifier.drawRoundedStrokeFrame(
    color: Color,
    frameThickness: Dp = 20.dp,
    dropWith: Dp = 70.dp,
    dropHeight: Dp = 45.dp,
    rectWith: Dp = 80.dp,
    rectHeight: Dp = 80.dp,
): Modifier = this.then(
    Modifier.drawBehind {
        val fw = frameThickness.toPx()
        val outer = Rect(0f, 0f, size.width, size.height)

        val path2 = buildDrop(
            rectWidth = size.width,
            rectHeight = size.height,
            padding = fw,
            rectBorderWidth = rectWith.toPx(),
            rectBorderHeight = rectHeight.toPx(),
            dropWith = dropWith.toPx(),
            dropHeight = dropHeight.toPx(),
        )
        val path = Path().apply {
            fillType = PathFillType.EvenOdd
            addRect(outer)
            addPath(
                buildRectWithProtrudingSquarePathCompose(
                    rectWidth = size.width,
                    rectHeight = size.height,
                    padding = fw,
                    rectBorderWidth = rectWith.toPx(),
                    rectBorderHeight = rectHeight.toPx(),
                )
            )
            addPath(path2)
        }
        drawPath(path = path, color = color)
    }
)

fun buildDrop(
    rectWidth: Float,
    rectHeight: Float,
    padding: Float,
    rectBorderWidth: Float,
    rectBorderHeight: Float,
    dropWith: Float,
    dropHeight: Float,
): Path {
    return Path().apply {
        moveTo(rectWidth - padding - rectBorderWidth / 2, rectHeight - padding)
        arcTo(
            rect = Rect(
                rectWidth - padding - rectBorderWidth,
                rectHeight - padding - rectBorderHeight,
                rectWidth - padding,
                rectHeight - padding
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                rectWidth - padding - rectBorderWidth - dropWith,
                rectHeight - padding - rectBorderHeight / 2 - dropHeight,
                rectWidth - padding - rectBorderWidth,
                rectHeight - padding - rectBorderHeight / 2,
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = -90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                padding,
                rectHeight - padding - rectBorderHeight * 2,
                padding + rectBorderWidth,
                rectHeight - padding - rectBorderHeight / 2 - dropHeight
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                padding,
                rectHeight - padding - rectBorderHeight,
                padding + rectBorderWidth,
                rectHeight - padding
            ),
            startAngleDegrees = 180f,
            sweepAngleDegrees = -90f,
            forceMoveTo = false
        )
        close()
    }
}

fun buildRectWithProtrudingSquarePathCompose(
    rectWidth: Float,
    rectHeight: Float,
    padding: Float,
    rectBorderWidth: Float,
    rectBorderHeight: Float,
): Path {
    return Path().apply {
        moveTo(padding + rectBorderWidth, padding)
        arcTo(
            rect = Rect(
                rectWidth - padding - rectBorderWidth,
                padding,
                rectWidth - padding,
                padding + rectBorderHeight
            ),
            startAngleDegrees = -90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                rectWidth - padding - rectBorderWidth,
                rectHeight - padding - rectBorderHeight,
                rectWidth - padding,
                rectHeight - padding
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                padding,
                rectHeight - padding - rectBorderHeight,
                padding + rectBorderWidth,
                rectHeight - padding
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        arcTo(
            rect = Rect(
                padding,
                padding,
                padding + rectBorderWidth,
                padding + rectBorderHeight
            ),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )
        close()
    }
}

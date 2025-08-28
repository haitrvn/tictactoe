package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp
) {
    Canvas(modifier = modifier) {
        val path = generateCubic(
            side = Side.TOP,
            width = size.width,
            height = size.height,
            dropSize = 60.dp.toPx(),
            cornerSize = 60.dp.toPx(),
            offset = 200.dp.toPx(),
        )
        drawPath(path, Color.Red, style = Stroke(width = 5f))
    }
}

enum class Side {
    TOP, BOTTOM, LEFT, RIGHT
}


/**
 * Sample path:
 * M 10 20 C 10 15 15 10 20 10 L 35 10 C 38 10 40 8 40 5 A 1 1 0 0 1 50 5 C 50 8 52 10 55 10
 * L 70 10 C 75 10 80 15 80 20 L 80 35 C 80 38 82 40 85 40 A 1 1 0 0 1 85 50 C 82 50 80 52 80 55
 * L 80 70 C 80 75 75 80 70 80 L 55 80 C 52 80 50 82 50 85 A 1 1 0 0 1 40 85 C 40 82 38 80 35 80
 * L 20 80 C 15 80 10 75 10 70 L 10 55 C 10 52 8 50 5 50 A 1 1 0 0 1 5 39 C 8 39 10 37 10 35 L 10 20 Z
 */
fun generateCubic(
    side: Side,
    width: Float,
    height: Float,
    dropSize: Float,
    cornerSize: Float,
    offset: Float,
): Path {
    val dropXY1 = offset
    val dropXY2 = offset + dropSize
    val halfDropSize = dropSize / 2
    val topDropY = if (side == Side.TOP) halfDropSize else 0f
    val topY = if (side == Side.TOP) dropSize else 0f
    val topCornerX1 = if (offset >= dropSize + cornerSize && side == Side.TOP) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val topDropX1 = if (offset > dropSize + cornerSize) {
        offset - halfDropSize
    } else {
        topCornerX1
    }

    val topCornerX2 = if (width - offset - dropSize >= cornerSize + dropSize && side == Side.TOP) {
        width - cornerSize
    } else {
        (width - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
    }
    val topDropX2 = if (width - offset - dropSize > cornerSize + dropSize) {
        offset + dropSize + halfDropSize
    } else {
        topCornerX2
    }
    val leftDropX1 = if (side == Side.LEFT) width - halfDropSize else 0f
    val leftY = if (side == Side.LEFT) width - dropSize else 0f

    val leftCornerY1 = if (offset >= dropSize + cornerSize && side == Side.LEFT) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val leftDropY1 = if (offset > dropSize + cornerSize) {
        offset - halfDropSize
    } else {
        leftCornerY1
    }

    val leftCornerX2 = if (width - offset - dropSize >= cornerSize + dropSize && side == Side.TOP) {
        cornerSize
    } else {
        (topY - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
    }
    return Path().apply {
        drawVerticalLine(topCornerX1, height)
        drawVerticalLine(topCornerX2, height)
        drawVerticalLine(topDropX1, height)
        drawVerticalLine(topDropX2, height)
        drawVerticalLine(dropXY1, height)
        drawVerticalLine(dropXY2, height)

        drawHorizontalLine(topDropY, width)
        drawHorizontalLine(topY, width)
    }
}

fun Path.drawVerticalLine(x: Float, canvasHeight: Float) {
    moveTo(x, 0f)
    lineTo(x, canvasHeight)
}

fun Path.cubicToPath(cubic: Cubic) {
    lineTo(cubic.startPoint.x, cubic.startPoint.y)
    cubicTo(
        cubic.controlPoint1.x,
        cubic.controlPoint1.y,
        cubic.controlPoint2.x,
        cubic.controlPoint2.y,
        cubic.endPoint.x,
        cubic.endPoint.y
    )
}

data class Point(val x: Float, val y: Float)

data class Cubic(
    val startPoint: Point,
    val endPoint: Point,
    val controlPoint1: Point,
    val controlPoint2: Point,
)

fun Path.drawHorizontalLine(y: Float, canvasWidth: Float) {
    moveTo(0f, y)
    lineTo(canvasWidth, y)
}
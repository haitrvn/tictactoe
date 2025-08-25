package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val padding = padding.toPx()
        drawRect(Color.Red)
        translate(padding, padding) {
            drawPath(
                color = Color.Black,
                path = Path().apply {
                    val width = size.width - padding * 2
                    val height = size.height - padding * 2
                    moveTo(padding, padding)
                    createCubicList(
                        width = width,
                        height = height,
                        dropSize = 60.dp.toPx(),
                        cornerSize = 40.dp.toPx(),
                        offset = 80.dp.toPx(),
                        side = Side.BOTTOM,
                    ).forEach {
                        moveToAndCubicTo(it)
                    }
                }
            )
        }
    }
}

fun createCubicList(
    width: Float,
    height: Float,
    dropSize: Float,
    cornerSize: Float,
    offset: Float,
    side: Side,
): List<Cubic> {
    val top = if (side == Side.TOP) dropSize else 0f
    val bottom = if (side == Side.BOTTOM) height - dropSize else height
    val left = if (side == Side.LEFT) dropSize else 0f
    val right = if (side == Side.RIGHT) width - dropSize else width

    val topCorner = if (side == Side.TOP) {
        (top + offset).coerceAtMost(top + cornerSize)
    } else {
        top + cornerSize
    }
    val bottomCorner = if (side == Side.BOTTOM) {
        (bottom - offset).coerceAtLeast(bottom - cornerSize)
    } else {
        bottom - cornerSize
    }
    val leftCorner = if (side == Side.LEFT) {
        (left + offset).coerceAtMost(left + cornerSize)
    } else {
        left + cornerSize
    }
    val rightCorner = if (side == Side.RIGHT) {
        (right - offset).coerceAtLeast(right - cornerSize)
    } else {
        right - cornerSize
    }

    val maxFootDropHeight = dropSize / 3

    val topFoot = if (side == Side.TOP) {
        top - maxFootDropHeight
    } else {
        top
    }
    val bottomFoot = if (side == Side.BOTTOM) {
        bottom + maxFootDropHeight
    } else {
        bottom
    }
    val leftFoot = if (side == Side.LEFT) {
        left - maxFootDropHeight
    } else {
        left
    }
    val rightFoot = if (side == Side.RIGHT) {
        right + maxFootDropHeight
    } else {
        right
    }

    val topDropHeader = if (side == Side.TOP) {
        top - dropSize
    } else {
        top
    }
    val bottomDropHeader = if (side == Side.BOTTOM) {
        bottom + dropSize
    } else {
        bottom
    }
    val leftDropHeader = if (side == Side.LEFT) {
        left - dropSize
    } else {
        left
    }
    val rightDropHeader = if (side == Side.RIGHT) {
        right + dropSize
    } else {
        right
    }

    val offset1 = offset.coerceAtMost(width - dropSize)
    val offset2 = offset1 + dropSize

    return listOf(
        //TOP_LEFT
        Cubic(
            startPoint = Point(left, topCorner),
            endPoint = Point(leftCorner, top),
            controlPoint1 = Point(left, topCorner - (topCorner - top) / 2),
            controlPoint2 = Point(leftCorner - (leftCorner - left) / 2, top),
        ),
        //TOP_DROP_FOOT_1
        Cubic(
            startPoint = Point(leftCorner, top),
            endPoint = Point(offset1, topFoot),
            controlPoint1 = Point(offset1, top),
            controlPoint2 = Point(offset1, top),
        ),
        //TOP_HEADER_DROP
        Cubic(
            startPoint = Point(offset1, topFoot),
            endPoint = Point(offset2, topFoot),
            controlPoint1 = Point(offset1, topDropHeader),
            controlPoint2 = Point(offset2, topDropHeader),
        ),
        //TOP_DROP_FOOT_2
        Cubic(
            startPoint = Point(offset2, topFoot),
            endPoint = Point(rightCorner, top),
            controlPoint1 = Point(offset2, top),
            controlPoint2 = Point(offset2, top),
        ),
        //TOP_RIGHT
        Cubic(
            startPoint = Point(rightCorner, top),
            endPoint = Point(right, topCorner),
            controlPoint1 = Point(rightCorner + (right - rightCorner) / 2, top),
            controlPoint2 = Point(right, topCorner - (topCorner - top) / 2),
        ),
        //RIGHT_DROP_FOOT_1
        Cubic(
            startPoint = Point(right, topCorner),
            endPoint = Point(rightFoot, offset1),
            controlPoint1 = Point(right, offset1),
            controlPoint2 = Point(right, offset1),
        ),
        //RIGHT_HEADER_DROP
        Cubic(
            startPoint = Point(rightFoot, offset1),
            endPoint = Point(rightFoot, offset2),
            controlPoint1 = Point(rightDropHeader, offset1),
            controlPoint2 = Point(rightDropHeader, offset2),
        ),
        //RIGHT_DROP_FOOT_2
        Cubic(
            startPoint = Point(rightFoot, offset2),
            endPoint = Point(right, bottomCorner),
            controlPoint1 = Point(right, offset2),
            controlPoint2 = Point(right, offset2),
        ),
        //BOTTOM_RIGHT
        Cubic(
            startPoint = Point(right, bottomCorner),
            endPoint = Point(rightCorner, bottom),
            controlPoint1 = Point(right, bottomCorner + (bottom - bottomCorner) / 2),
            controlPoint2 = Point(rightCorner + (right - rightCorner) / 2, bottom)
        ),
        //BOTTOM_DROP_FOOT_1
        Cubic(
            startPoint = Point(rightCorner, bottom),
            endPoint = Point(offset2, bottomFoot),
            controlPoint1 = Point(offset2, bottom),
            controlPoint2 = Point(offset2, bottom),
        ),
        //BOTTOM_HEADER_DROP
        Cubic(
            startPoint = Point(offset2, bottomFoot),
            endPoint = Point(offset1, bottomFoot),
            controlPoint1 = Point(offset2, bottomDropHeader),
            controlPoint2 = Point(offset1, bottomDropHeader),
        ),
        //BOTTOM_DROP_FOOT_2
        Cubic(
            startPoint = Point(offset1, bottomFoot),
            endPoint = Point(leftCorner, bottom),
            controlPoint1 = Point(offset1, bottom),
            controlPoint2 = Point(offset1, bottom),
        ),
        //BOTTOM_LEFT
        Cubic(
            startPoint = Point(leftCorner, bottom),
            endPoint = Point(left, bottomCorner),
            controlPoint1 = Point(leftCorner - (leftCorner - left) / 2, bottom),
            controlPoint2 = Point(left, bottomCorner + (bottom - bottomCorner) / 2)
        ),
        //LEFT_DROP_FOOT_1
        Cubic(
            startPoint = Point(left, bottomCorner),
            endPoint = Point(leftFoot, offset2),
            controlPoint1 = Point(left, offset2),
            controlPoint2 = Point(left, offset2),
        ),
        //LEFT_HEADER_DROP
        Cubic(
            startPoint = Point(leftFoot, offset2),
            endPoint = Point(leftFoot, offset1),
            controlPoint1 = Point(leftDropHeader, offset2),
            controlPoint2 = Point(leftDropHeader, offset1),
        ),
        //LEFT_DROP_FOOT_2
        Cubic(
            startPoint = Point(leftFoot, offset1),
            endPoint = Point(left, topCorner),
            controlPoint1 = Point(left, offset1),
            controlPoint2 = Point(left, offset1),
        ),
    )
}


fun Path.moveToAndCubicTo(cubic: Cubic) {
    lineTo(cubic.startPoint.x, cubic.startPoint.y)
    cubicTo(
        cubic.controlPoint1.x,
        cubic.controlPoint1.y,
        cubic.controlPoint2.x,
        cubic.controlPoint2.y,
        cubic.endPoint.x,
        cubic.endPoint.y,
    )
//    moveTo(cubic.startPoint.x, cubic.startPoint.y)
//    drawDot(cubic.startPoint.x, cubic.startPoint.y)
//    drawDot(cubic.controlPoint1.x, cubic.controlPoint1.y)
//    drawDot(cubic.controlPoint2.x, cubic.controlPoint2.y)
//    drawDot(cubic.endPoint.x, cubic.endPoint.y)
}

private fun Path.drawDot(
    x: Float,
    y: Float,
    dotRadius: Float = 2f
) {
    addOval(
        Rect(
            left = x - dotRadius,
            top = y - dotRadius,
            right = x + dotRadius,
            bottom = y + dotRadius
        )
    )
}

data class Point(val x: Float, val y: Float)

enum class Side {
    TOP,
    BOTTOM,
    LEFT,
    RIGHT,
}

data class Cubic(
    val startPoint: Point,
    val endPoint: Point,
    val controlPoint1: Point,
    val controlPoint2: Point,
)
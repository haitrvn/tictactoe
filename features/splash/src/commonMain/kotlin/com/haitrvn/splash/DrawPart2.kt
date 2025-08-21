package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
        drawPath(
            color = Color.Black,
//            blendMode = BlendMode.Clear,
            path = Path().apply {
                val width = size.width - padding
                val height = size.height - padding
                translate(Offset(padding, padding))
                createCubicList(
                    width = width,
                    height = height,
                    dropSize = 40.dp.toPx(),
                    cornerSize = 40.dp.toPx(),
                    offset = 80.dp.toPx(),
                    side = Side.TOP,
                ).forEach {
                    moveToAndCubicTo(it)
                }
            }
        )
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
    //Top lines
    val topCornerOutside = if (side == Side.TOP) dropSize else 0f
    val topCornerInside = (if (side == Side.TOP) dropSize else 0f) + cornerSize
    val topDrop = if (side == Side.TOP) dropSize / 2 else 0f

    //Left lines
    val leftCornerOutside = if (side == Side.LEFT) dropSize else 0f
    val leftCornerInside = (if (side == Side.LEFT) dropSize else 0f) + cornerSize
    val leftDrop = if (side == Side.LEFT) dropSize / 2 else 0f

    //Right lines
    val rightCornerOutside = if (side == Side.RIGHT) width - dropSize else width
    val rightCornerInside = (if (side == Side.RIGHT) width - dropSize else width) - cornerSize
    val rightDrop = if (side == Side.RIGHT) width - dropSize / 2 else width

    //Bottom lines
    val bottomCornerOutside = if (side == Side.BOTTOM) height - dropSize else height
    val bottomCornerInside = (if (side == Side.BOTTOM) height - dropSize else height) - cornerSize
    val bottomDrop = if (side == Side.BOTTOM) height - dropSize / 2 else height

    //Offset lines
    val (offset1, offset2, offset3, offset4) = when (side) {
        Side.TOP, Side.BOTTOM -> Quadruple(
            offset1 = (offset / 2),
            offset2 = offset,
            offset3 = offset + dropSize,
            offset4 = offset + dropSize + (width - offset - dropSize) / 2,
        )

        Side.LEFT, Side.RIGHT -> Quadruple(
            offset1 = (offset / 2),
            offset2 = offset,
            offset3 = offset + dropSize,
            offset4 = offset + dropSize + (height - offset - dropSize) / 2,
        )
    }



    return listOf(
        Cubic.BottomRight(
            startPoint = Point(offset1, topCornerOutside),
            endPoint = Point(offset2, topDrop),
        ),
        Cubic.Top(
            startPoint = Point(offset2, topDrop),
            endPoint = Point(offset3, topDrop),
        ),
        Cubic.BottomLeft(
            startPoint = Point(offset3, topDrop),
            endPoint = Point(offset4, topCornerOutside),
        ),
        Cubic.TopRight(
            startPoint = Point(offset3, topDrop),
            endPoint = Point(offset4, topCornerOutside),
        )
    )
}

data class Quadruple(
    val offset1: Float,
    val offset2: Float,
    val offset3: Float,
    val offset4: Float,
)

fun Path.moveToAndCubicTo(cubic: Cubic) {
    moveTo(cubic.startPoint.x, cubic.startPoint.y)
    cubicTo(
        cubic.endPoint.x,
        cubic.endPoint.y,
        cubic.controlPoint1.x,
        cubic.controlPoint1.y,
        cubic.controlPoint2.x,
        cubic.controlPoint2.y,
    )
}

data class Point(val x: Float, val y: Float)

enum class Side {
    TOP,
    BOTTOM,
    LEFT,
    RIGHT,
}

sealed class Cubic(
    open val startPoint: Point,
    open val endPoint: Point,
    open val controlPoint1: Point,
    open val controlPoint2: Point,
) {
    data class TopLeft(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class TopRight(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
        override val controlPoint2: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class BottomLeft(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
        override val controlPoint2: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class BottomRight(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class Top(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class Bottom(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class Left(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )

    data class Right(
        override val startPoint: Point,
        override val endPoint: Point,
        override val controlPoint1: Point = Point(
            x = startPoint.x,
            y = (startPoint.y + endPoint.y) / 2
        ),
        override val controlPoint2: Point = Point(
            x = (startPoint.x + endPoint.x) / 2,
            y = startPoint.y
        ),
    ) : Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2,
    )
}
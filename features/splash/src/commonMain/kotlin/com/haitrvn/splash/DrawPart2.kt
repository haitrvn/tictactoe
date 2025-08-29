package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp,
    isShowDot: Boolean = false
) {
    Canvas(modifier = modifier) {
        val path = Path().apply {
            fillType = PathFillType.EvenOdd
            addRect(rect = Rect(0f, 0f, size.width, size.height))
            translate(left = padding.toPx(), top = padding.toPx()) {
                generateCubic(
                    side = Side.TOP,
                    width = size.width - padding.toPx() * 2,
                    height = size.height - padding.toPx() * 2,
                    dropSize = 40.dp.toPx(),
                    cornerSize = 60.dp.toPx(),
                    offset = size.width - padding.toPx() * 2 - 40.dp.toPx(),
                ).apply {
                    moveTo(first().startPoint.x, first().startPoint.y)
                }.forEach {
                    if (isShowDot) {
                        cubicPoint(it)
                    } else {
                        cubicToPath(it)
                    }
                }
                close()
            }
        }
        drawPath(path, Color.Red)
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
): List<Cubic> {
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

    val topCornerX2 =
        if (width - offset - dropSize >= cornerSize + dropSize && side == Side.TOP || side != Side.TOP) {
            if (side == Side.RIGHT) {
                width - cornerSize - dropSize
            } else {
                width - cornerSize
            }
        } else {
            (width - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
        }
    val topDropX2 = if (width - offset - dropSize > cornerSize + dropSize && side == Side.TOP) {
        offset + dropSize + halfDropSize
    } else {
        topCornerX2
    }

    //Bottom
    val bottomDropY = if (side == Side.BOTTOM) height - halfDropSize else height
    val bottomY = if (side == Side.BOTTOM) height - dropSize else height
    val bottomCornerX1 = if (offset >= dropSize + cornerSize && side == Side.BOTTOM) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val bottomDropX1 = if (offset > dropSize + cornerSize && side == Side.BOTTOM) {
        offset - halfDropSize
    } else {
        bottomCornerX1
    }

    val bottomCornerX2 =
        if (width - offset - dropSize >= cornerSize + dropSize && side == Side.BOTTOM || side != Side.BOTTOM) {
            width - cornerSize
        } else {
            (width - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
        }
    val bottomDropX2 =
        if (width - offset - dropSize > cornerSize + dropSize && side == Side.BOTTOM) {
            offset + dropSize + halfDropSize
        } else {
            bottomCornerX2
        }

    //Right
    val rightDropX = if (side == Side.RIGHT) width - halfDropSize else width
    val rightX = if (side == Side.RIGHT) width - dropSize else width

    val rightCornerY1 =
        if (offset >= dropSize + cornerSize && side == Side.RIGHT || side != Side.RIGHT) {
            topY + cornerSize
        } else {
            offset * (cornerSize / (cornerSize + dropSize))
        }
    val rightDropY1 = if (offset > dropSize + cornerSize && side == Side.RIGHT) {
        offset - halfDropSize
    } else {
        rightCornerY1
    }

    val rightCornerY2 =
        if (width - offset - dropSize >= cornerSize + dropSize && side == Side.RIGHT || side != Side.RIGHT) {
            if (side == Side.BOTTOM) {
                height - cornerSize - dropSize
            } else {
                height - cornerSize
            }
        } else {
            (height - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
        }
    val rightDropY2 = if (width - offset - dropSize > cornerSize + dropSize && side == Side.RIGHT) {
        offset + dropSize + halfDropSize
    } else {
        rightCornerY2
    }

    //Left
    val leftDropX = if (side == Side.LEFT) halfDropSize else 0f
    val leftX = if (side == Side.LEFT) dropSize else 0f

    val leftCornerY1 = if (side != Side.LEFT || offset >= dropSize + cornerSize) {
        topY + cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val leftDropY1 = if (offset > dropSize + cornerSize && side == Side.LEFT) {
        offset - halfDropSize
    } else {
        leftCornerY1
    }

    val leftCornerY2 =
        if (width - offset - dropSize >= cornerSize + dropSize && side == Side.LEFT || side != Side.LEFT) {
            if (side == Side.BOTTOM) {
                height - cornerSize - dropSize
            } else {
                height - cornerSize
            }
        } else {
            (height - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
        }
    val leftDropY2 = if (width - offset - dropSize > cornerSize + dropSize && side == Side.LEFT) {
        offset + dropSize + halfDropSize
    } else {
        leftCornerY2
    }
    return listOf(
        topLeftCubic(Point(leftX, leftCornerY1), Point(topCornerX1, topY)),
//        bottomRightCubic(Point(topDropX1, topY), Point(dropXY1, topDropY)),
//        Cubic(
//            Point(dropXY1, topDropY),
//            Point(dropXY2, topDropY),
//            Point(dropXY1, topDropY - dropSize * 3 / 4),
//            Point(dropXY2, topDropY - dropSize * 3 / 4),
//        ),
//        bottomLeftCubic(Point(dropXY2, topDropY), Point(topDropX2, topY)),
        topRightCubic(Point(topCornerX2, topY), Point(rightX, rightCornerY1)),
//        bottomLeftCubic(Point(rightX, rightDropY1), Point(rightDropX, dropXY1)),
//        Cubic(
//            Point(rightDropX, dropXY1),
//            Point(rightDropX, dropXY2),
//            Point(rightDropX + dropSize * 3 / 4, dropXY1),
//            Point(rightDropX + dropSize * 3 / 4, dropXY2),
//        ),
//        topLeftCubic(Point(rightDropX, dropXY2), Point(rightX, rightDropY2)),
        bottomRightCubic(Point(rightX, rightCornerY2), Point(bottomCornerX2, bottomY)),
//        topLeftCubic(Point(bottomDropX2, bottomY), Point(dropXY2, bottomDropY)),
//        Cubic(
//            Point(dropXY2, bottomDropY),
//            Point(dropXY1, bottomDropY),
//            Point(dropXY2, bottomDropY + dropSize * 3 / 4),
//            Point(dropXY1, bottomDropY + dropSize * 3 / 4),
//        ),
//        topRightCubic(Point(dropXY1, bottomDropY), Point(bottomDropX1, bottomY)),
        bottomLeftCubic(Point(bottomCornerX1, bottomY), Point(leftX, leftCornerY2)),
//        topRightCubic(Point(leftX,leftDropY2), Point(leftDropX,dropXY2)),
//        Cubic(
//            Point(leftDropX, dropXY2),
//            Point(leftDropX, dropXY1),
//            Point(leftDropX - dropSize * 3 / 4, dropXY2),
//            Point(leftDropX - dropSize * 3 / 4, dropXY1),
//        ),
//        bottomRightCubic(Point(leftDropX, dropXY1), Point(leftX, leftDropY1)),
    )
}

fun Path.drawCircle(point: Point, radius: Float = 2f) {
    moveTo(point.x, point.y)
    addOval(Rect(point.x - radius, point.y - radius, point.x + radius, point.y + radius))
}

fun Path.cubicPoint(cubic: Cubic) {
    drawCircle(cubic.startPoint)
    drawCircle(cubic.endPoint)
    drawCircle(cubic.controlPoint1)
    drawCircle(cubic.controlPoint2)
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

fun topLeftCubic(
    startPoint: Point,
    endPoint: Point,
    scale1: Float = 0.85f,
    scale2: Float = 0.85f,
): Cubic {
    val conditional = startPoint.y - endPoint.y >= 0
    val controlPoint1 = if (conditional) {
        Point(
            startPoint.x,
            startPoint.y - (startPoint.y - endPoint.y) * scale1,
        )
    } else {
        Point(
            startPoint.x - (startPoint.x - endPoint.x) * scale1,
            startPoint.y,
        )
    }
    val controlPoint2 = if (conditional) {
        Point(
            endPoint.x - (endPoint.x - startPoint.x) * scale2,
            endPoint.y
        )
    } else {
        Point(
            endPoint.x,
            endPoint.y - (endPoint.y - startPoint.y) * scale2
        )
    }
    return Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2
    )
}

fun topRightCubic(
    startPoint: Point,
    endPoint: Point,
    scale1: Float = 0.85f,
    scale2: Float = 0.85f,
): Cubic {
    val conditional = startPoint.x - endPoint.x > 0
    val controlPoint1 = if (conditional) {
        Point(
            startPoint.x,
            startPoint.y - (startPoint.y - endPoint.y) * scale1,
        )
    } else {
        Point(
            startPoint.x + (endPoint.x - startPoint.x) * scale1,
            startPoint.y,
        )
    }
    val controlPoint2 = if (conditional) {
        Point(
            endPoint.x + (startPoint.x - endPoint.x) * scale2,
            endPoint.y,
        )
    } else {
        Point(
            endPoint.x,
            endPoint.y - (endPoint.y - startPoint.y) * scale2,
        )
    }
    return Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2
    )
}

fun bottomLeftCubic(
    startPoint: Point,
    endPoint: Point,
    scale1: Float = 0.85f,
    scale2: Float = 0.85f,
): Cubic {
    val conditional = startPoint.x - endPoint.x > 0
    val controlPoint1 = if (conditional) {
        Point(
            startPoint.x - (startPoint.x - endPoint.x) * scale1,
            startPoint.y,
        )
    } else {
        Point(
            startPoint.x,
            startPoint.y + (endPoint.y - startPoint.y) * scale1
        )
    }
    val controlPoint2 = if (conditional) {
        Point(
            endPoint.x,
            endPoint.y + (startPoint.y - endPoint.y) * scale2,
        )
    } else {
        Point(
            endPoint.x - (endPoint.x - startPoint.x) * scale2,
            endPoint.y
        )
    }
    return Cubic(startPoint, endPoint, controlPoint1, controlPoint2)
}

fun bottomRightCubic(
    startPoint: Point,
    endPoint: Point,
    scale1: Float = 0.85f,
    scale2: Float = 0.85f,
): Cubic {
    val conditional = endPoint.y - startPoint.y > 0
    val controlPoint1 = if (conditional) {
        Point(
            startPoint.x,
            startPoint.y + (endPoint.y - startPoint.y) * scale1,
        )
    } else {
        Point(
            startPoint.x + (endPoint.x - startPoint.x) * scale1,
            startPoint.y
        )
    }
    val controlPoint2 = if (conditional) {
        Point(
            endPoint.x + (startPoint.x - endPoint.x) * scale2,
            endPoint.y,
        )
    } else {
        Point(
            endPoint.x,
            endPoint.y + (startPoint.y - endPoint.y) * scale2,
        )
    }
    return Cubic(
        startPoint = startPoint,
        endPoint = endPoint,
        controlPoint1 = controlPoint1,
        controlPoint2 = controlPoint2
    )
}

data class Point(val x: Float, val y: Float)

sealed interface Shape
data class Cubic(
    val startPoint: Point,
    val endPoint: Point,
    val controlPoint1: Point,
    val controlPoint2: Point,
) : Shape

data class ARC(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
)
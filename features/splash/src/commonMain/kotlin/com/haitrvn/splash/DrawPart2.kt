package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    side: Side = Side.BOTTOM,
    dropSize: Dp = 50.dp,
    cornerSize: Dp = 50.dp,
    offset: Dp = 40.dp,
) {
    Canvas(modifier = modifier) {
        val paddingPx = padding.toPx()
        val dropSizePx = dropSize.toPx()
        val cornerSizePx = cornerSize.toPx()
        val offsetPx = offset.toPx()
        drawRect(Color.White)
        inset(paddingPx) {
            val path = Path().apply {
                fillType = PathFillType.EvenOdd
                generateCubic(
                    side = side,
                    width = size.width,
                    height = size.height,
                    dropSize = dropSizePx,
                    cornerSize = cornerSizePx,
                    offset = offsetPx,
                ).apply {
                    moveTo(first().startPoint.x, first().startPoint.y)
                }.forEach { cubic ->
                    cubicToPath(cubic)
                }
                close()
            }
            drawPath(path, Color.Red)
        }

        inset(paddingPx) {
            val left = if (side == Side.RIGHT) {
                size.width - dropSizePx
            } else {
                0f
            }
            val right = if (side == Side.LEFT) {
                size.width - dropSizePx
            } else {
                0f
            }
            val top = if (side == Side.BOTTOM) {
                size.height - dropSizePx
            } else {
                0f
            }
            val bottom = if (side == Side.TOP) {
                size.height - dropSizePx
            } else {
                0f
            }
            inset(left = left, right = right, top = top, bottom = bottom) {
                scale(
                    scaleX = if (side == Side.RIGHT) -1f else 1f,
                    scaleY = if (side == Side.TOP) -1f else 1f
                ) {
                    rotate(
                        degrees = if (side == Side.RIGHT || side == Side.LEFT) 90f else 0f,
                        pivot = Offset(dropSizePx / 2, dropSizePx / 2)
                    ) {
                        val path = Path().apply {
                            fillType = PathFillType.EvenOdd
                            generateDropCubic(
                                dropSize = dropSizePx,
                                offset = offsetPx,
                                cornerSize = cornerSizePx,
                                width = size.width,
                            ).apply {
                                moveTo(first().startPoint.x, first().startPoint.y)
                            }.forEach {
                                cubicToPath(it)
                            }
                            close()
                        }
                        drawPath(path, Color.Red)
                    }
                }
            }
        }
    }
}

enum class Side {
    TOP, BOTTOM, LEFT, RIGHT
}

fun generateDropCubic(
    dropSize: Float,
    offset: Float,
    cornerSize: Float,
    width: Float,
): List<Cubic> {
    val smallDropSize = dropSize / 2
    val corner = if (offset >= cornerSize + dropSize) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val drop1 = if (offset >= cornerSize + dropSize) {
        offset - smallDropSize
    } else {
        corner
    }
    return listOf(
        bottomLeftCubic(
            startPoint = Point(0f, -cornerSize),
            endPoint = Point(corner, 0f),
            scale1 = 1f,
            scale2 = 0.1f,
        ),
        topRightCubic(
            startPoint = Point(drop1, 0f),
            endPoint = Point(offset, smallDropSize),
            scale1 = 1f,
            scale2 = 0.1f,
        ),
        Cubic(
            startPoint = Point(offset, smallDropSize),
            endPoint = Point(offset + dropSize, smallDropSize),
            controlPoint1 = Point(offset, dropSize * 1.2f),
            controlPoint2 = Point(offset + dropSize, dropSize * 1.2f),
        ),
        topLeftCubic(
            startPoint = Point(offset + dropSize, smallDropSize),
            endPoint = Point(offset + dropSize + smallDropSize, 0f),
        ),
        bottomRightCubic(
            startPoint = Point(offset + dropSize + smallDropSize, 0f),
            endPoint = Point(offset + dropSize + smallDropSize + corner, -cornerSize),
        )
    )
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
    val start = when (side) {
        Side.LEFT -> dropSize
        else -> 0f
    }
    val end = when (side) {
        Side.RIGHT -> width - dropSize
        else -> width
    }
    val top = when (side) {
        Side.TOP -> dropSize
        else -> 0f
    }
    val bottom = when (side) {
        Side.BOTTOM -> height - dropSize
        else -> height
    }
    return listOf(
        topLeftCubic(
            startPoint = Point(start, top + cornerSize),
            endPoint = Point(start + cornerSize, top),
        ),
        topRightCubic(
            startPoint = Point(end - cornerSize, top),
            endPoint = Point(end, top + cornerSize),
        ),
        bottomRightCubic(
            startPoint = Point(end, bottom - cornerSize),
            endPoint = Point(end - cornerSize, bottom),
        ),
        bottomLeftCubic(
            startPoint = Point(start + cornerSize, bottom),
            endPoint = Point(start, bottom - cornerSize),
        ),
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
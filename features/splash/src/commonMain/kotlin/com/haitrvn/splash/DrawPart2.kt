package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    side: Side = Side.RIGHT,
    dropSize: Dp = 60.dp,
    cornerSize: Dp = 60.dp,
    offset: Dp? = null,
) {
    Canvas(modifier = modifier.graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)) {
        val paddingPx = padding.toPx()
        val dropSizePx = dropSize.toPx()
        val cornerSizePx = cornerSize.toPx()
        val offsetPx = offset?.toPx()
            ?: if (side == Side.RIGHT || side == Side.LEFT) size.height else size.width
        drawRect(Color.White)
        inset(paddingPx) {
            val path = Path().apply {
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
            drawPath(path, Color.Red, blendMode = BlendMode.Clear)
        }

        inset(paddingPx) {
            val left = if (side == Side.RIGHT) {
                size.width - dropSizePx - cornerSizePx
            } else {
                0f
            }
            val right = if (side == Side.LEFT) {
                size.width - dropSizePx - cornerSizePx
            } else {
                0f
            }
            val top = if (side == Side.BOTTOM) {
                size.height - dropSizePx - cornerSizePx
            } else {
                0f
            }
            val bottom = if (side == Side.TOP) {
                size.height - dropSizePx - cornerSizePx
            } else {
                0f
            }
            inset(left = left, right = right, top = top, bottom = bottom) {
                scale(
                    scaleX = if (side == Side.LEFT) -1f else 1f,
                    scaleY = if (side == Side.TOP) -1f else 1f,
                ) {
                    val path = Path().apply {
                        generateDropCubic(
                            side = side,
                            dropSize = dropSizePx,
                            offset = offsetPx,
                            cornerSize = cornerSizePx,
                            width = size.width,
                            height = size.height,
                        ).apply {
                            (firstOrNull() as? Cubic)?.let {
                                moveTo(it.startPoint.x, it.startPoint.y)
                            }
                        }.forEach {
                            cubicToPath(it)
                        }
                        close()
                    }
                    drawPath(path = path, color = Color.Transparent, blendMode = BlendMode.Clear)
                }
            }
        }
    }
}

enum class Side {
    TOP, BOTTOM, LEFT, RIGHT
}

fun generateDropCubic(
    side: Side,
    dropSize: Float,
    offset: Float,
    cornerSize: Float,
    width: Float,
    height: Float,
): List<Cubic> {
    return when (side) {
        Side.LEFT, Side.RIGHT -> {
            generateHorizontalDropCubic(
                dropSize,
                offset,
                cornerSize,
                height,
            )
        }

        Side.TOP, Side.BOTTOM -> {
            generateVerticalDropCubic(
                side,
                dropSize,
                offset,
                cornerSize,
                width,
            )
        }
    }
}

private fun generateHorizontalDropCubic(
    dropSize: Float,
    offset: Float,
    cornerSize: Float,
    height: Float,
): List<Cubic> {
    val offset = offset.coerceAtMost(height - dropSize)
    val smallDropSize = dropSize / 3
    val x1 = 0f
    val x2 = cornerSize
    val x3 = cornerSize + smallDropSize
    val y1 = 0f
    val y2 = if (offset > cornerSize + dropSize) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val y3 = if (offset > cornerSize + dropSize) {
        offset - smallDropSize
    } else {
        y2
    }
    val y4 = offset
    val y5 = offset + dropSize
    val y6 = if (height - offset - dropSize > cornerSize + dropSize) {
        y5 + smallDropSize
    } else {
        height - (height - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
    }
    val y7 = if (height - offset - dropSize > cornerSize + dropSize) {
        height - cornerSize
    } else {
        y6
    }
    val y8 = height
    return listOf(
        topRightCubic(
            startPoint = Point(x1, y1),
            endPoint = Point(x2, y2)
        ),
        bottomLeftCubic(
            startPoint = Point(x2, y3),
            endPoint = Point(x3, y4),
        ),
        Cubic(
            startPoint = Point(x3, y4),
            endPoint = Point(x3, y5),
            controlPoint1 = Point(x3 + dropSize * 3 / 4, y4),
            controlPoint2 = Point(x3 + dropSize * 3 / 4, y5),
        ),
        topLeftCubic(
            startPoint = Point(x3, y5),
            endPoint = Point(x2, y6),
        ),
        bottomRightCubic(
            startPoint = Point(x2, y7),
            endPoint = Point(x1, y8),
        )
    )
}

private fun generateVerticalDropCubic(
    side: Side,
    dropSize: Float,
    offset: Float,
    cornerSize: Float,
    width: Float,
): List<Cubic> {
    val offset = offset.coerceAtMost(width - dropSize)
    val smallDropSize = dropSize / 3
    val y1 = 0f
    val y2 = cornerSize
    val y3 = cornerSize + smallDropSize
    val x1 = 0f
    val x2 = if (offset > cornerSize + dropSize) {
        cornerSize
    } else {
        offset * (cornerSize / (cornerSize + dropSize))
    }
    val x3 = if (offset > cornerSize + dropSize) {
        offset - smallDropSize
    } else {
        x2
    }
    val x4 = offset
    val x5 = offset + dropSize
    val x6 = if (width - offset - dropSize > cornerSize + dropSize) {
        x5 + smallDropSize
    } else {
        width - (width - offset - dropSize) * (cornerSize / (cornerSize + dropSize))
    }
    val x7 = if (width - offset - dropSize > cornerSize + dropSize) {
        width - cornerSize
    } else {
        x6
    }
    val x8 = width
    return listOf(
        bottomLeftCubic(
            startPoint = Point(x1, y1),
            endPoint = Point(x2, y2)
        ),
        topRightCubic(
            startPoint = Point(x3, y2),
            endPoint = Point(x4, y3),
        ),
        Cubic(
            startPoint = Point(x4, y3),
            endPoint = Point(x5, y3),
            controlPoint1 = Point(x4, y3 + dropSize),
            controlPoint2 = Point(x5, y3 + dropSize),
        ),
        topLeftCubic(
            startPoint = Point(x5, y3),
            endPoint = Point(x6, y2),
        ),
        bottomRightCubic(
            startPoint = Point(x7, y2),
            endPoint = Point(x8, y1),
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

data class Cubic(
    val startPoint: Point,
    val endPoint: Point,
    val controlPoint1: Point,
    val controlPoint2: Point,
)
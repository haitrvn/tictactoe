package com.haitrvn.splash

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val ZERO = 0f
private const val SCALE_FLOAT = 1f
private const val INVERTED_SCALE_FLOAT = -1f
private const val DEFAULT_SCALE_1 = 0.85f
private const val DEFAULT_SCALE_2 = 0.85f
private const val DROP_SIZE_DIVISOR = 3
private const val DROP_SIZE_MULTIPLIER = 3 / 4f

@Composable
fun Drop(
    modifier: Modifier = Modifier,
    padding: Dp = 16.dp,
    side: Side = Side.BOTTOM,
    dropSize: Dp = 100.dp,
    cornerSize: Dp = 70.dp,
    offset: Dp? = null,
) {
    Canvas(modifier = modifier.graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)) {
        val paddingPx = padding.toPx()
        val dropSizePx = dropSize.toPx()
        val cornerSizePx = cornerSize.toPx()
        val offsetPx = offset?.toPx()
            ?: if (side.isHorizontal()) size.height else size.width
        drawRect(Color.White)
        inset(paddingPx) {
            val path = Path().apply {
                generateCubic(
                    side = side,
                    width = size.width,
                    height = size.height,
                    dropSize = dropSizePx,
                    cornerSize = cornerSizePx,
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
                ZERO
            }
            val right = if (side == Side.LEFT) {
                size.width - dropSizePx - cornerSizePx
            } else {
                ZERO
            }
            val top = if (side == Side.BOTTOM) {
                size.height - dropSizePx - cornerSizePx
            } else {
                ZERO
            }
            val bottom = if (side == Side.TOP) {
                size.height - dropSizePx - cornerSizePx
            } else {
                ZERO
            }
            inset(left = left, right = right, top = top, bottom = bottom) {
                scale(
                    scaleX = if (side == Side.LEFT) INVERTED_SCALE_FLOAT else SCALE_FLOAT,
                    scaleY = if (side == Side.TOP) INVERTED_SCALE_FLOAT else SCALE_FLOAT,
                ) {
                    val path = Path().apply {
                        generateDropCubic(
                            side = side, // Fix: Use the provided side parameter
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

fun Side.isHorizontal(): Boolean {
    return this == Side.LEFT || this == Side.RIGHT
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
    val smallDropSize = dropSize / DROP_SIZE_DIVISOR
    val x1 = ZERO
    val x2 = cornerSize
    val x3 = cornerSize + smallDropSize
    val y1 = ZERO
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
            controlPoint1 = Point(x3 + dropSize * DROP_SIZE_MULTIPLIER, y4),
            controlPoint2 = Point(x3 + dropSize * DROP_SIZE_MULTIPLIER, y5),
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
    dropSize: Float,
    offset: Float,
    cornerSize: Float,
    width: Float,
): List<Cubic> {
    val offset = offset.coerceAtMost(width - dropSize)
    val smallDropSize = dropSize / DROP_SIZE_DIVISOR
    val y1 = ZERO
    val y2 = cornerSize
    val y3 = cornerSize + smallDropSize
    val x1 = ZERO
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
            controlPoint1 = Point(x4, y3 + dropSize * DROP_SIZE_MULTIPLIER),
            controlPoint2 = Point(x5, y3 + dropSize * DROP_SIZE_MULTIPLIER),
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

fun generateCubic(
    side: Side,
    width: Float,
    height: Float,
    dropSize: Float,
    cornerSize: Float,
): List<Cubic> {
    val start = when (side) {
        Side.LEFT -> dropSize
        else -> ZERO
    }
    val end = when (side) {
        Side.RIGHT -> width - dropSize
        else -> width
    }
    val top = when (side) {
        Side.TOP -> dropSize
        else -> ZERO
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
    scale1: Float = DEFAULT_SCALE_1,
    scale2: Float = DEFAULT_SCALE_2,
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
    scale1: Float = DEFAULT_SCALE_1,
    scale2: Float = DEFAULT_SCALE_2,
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
    scale1: Float = DEFAULT_SCALE_1,
    scale2: Float = DEFAULT_SCALE_2,
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
    scale1: Float = DEFAULT_SCALE_1,
    scale2: Float = DEFAULT_SCALE_2,
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
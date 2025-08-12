package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SharedYourRecipesScreen(
    modifier: Modifier = Modifier,
    pageCount: Int = 5,
    frameCornerRadius: Dp = 28.dp,
    frameStrokeWidth: Dp = 28.dp
) {
    Box(modifier = modifier.fillMaxSize()) {
        val pagerState = rememberPagerState { pageCount }

        Box(modifier = Modifier.fillMaxSize()) {

            // Lớp 1 (dưới cùng): ViewPager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                // demo nội dung trang — sau này bạn thay bằng nội dung thật
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(
                            when (page % 5) {
                                0 -> Color(0xFF3B82F6)
                                1 -> Color(0xFF10B981)
                                2 -> Color(0xFFF59E0B)
                                3 -> Color(0xFF8B5CF6)
                                else -> Color(0xFFEF4444)
                            }
                        )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawRoundedStrokeFrame(
                        color = Color.White,
                        innerCornerRadius = frameCornerRadius,
                        frameThickness = frameStrokeWidth
                    )
            )
        }
    }
}

private fun Modifier.drawRoundedStrokeFrame(
    color: Color,
    innerCornerRadius: Dp,
    frameThickness: Dp,
    dropWith: Dp = 30.dp,
    dropHeight: Dp = 30.dp
): Modifier = this.then(
    Modifier.drawBehind {
        val fw = frameThickness.toPx()
        val outer = Rect(0f, 0f, size.width, size.height)
        val inner = Rect(fw, fw, size.width - fw, size.height - fw)
        val r = innerCornerRadius.toPx()
            .coerceAtMost(inner.width / 6f)
            .coerceAtMost(inner.height / 6f)

        val path = Path().apply {
            fillType = PathFillType.EvenOdd
            addRect(outer)
            addPath(
                buildRectWithProtrudingSquarePathCompose(
                    rectWidth = size.width,
                    rectHeight = size.height,
                    padding = fw,
                    rectBorderWidth = size.width / 4,
                    rectBorderHeight = size.width / 4,
                )
            )
        }
        drawPath(path = path, color = color)
        val path2 = buildDrop(
            rectWidth = size.width,
            rectHeight = size.height,
            padding = fw,
            rectBorderWidth = size.width / 4,
            rectBorderHeight = size.width / 4,
            dropWith = size.width / 15,
            dropHeight = size.width / 15,
        )
        drawPath(path = path2, color = Color.Red)
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
                rectHeight - padding - rectBorderHeight - dropHeight,
                rectWidth - padding - rectBorderWidth,
                rectHeight - padding - rectBorderHeight,
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = -90f,
            forceMoveTo = false
        )
        lineTo(rectWidth - padding - dropWith - rectBorderWidth, rectHeight - padding - dropHeight)
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
        lineTo(rectWidth - padding - rectBorderWidth, padding)
        //BorderTopRight
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
        lineTo(rectWidth - padding, rectHeight - padding - rectBorderHeight)
        //BorderBottomRight
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
        lineTo(padding + rectBorderWidth, rectHeight - padding)
        //BorderBottomLeft
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
        lineTo(padding, padding + rectBorderHeight)
        //BorderTopLeft
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

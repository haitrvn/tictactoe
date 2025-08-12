package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

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
    frameThickness: Dp
): Modifier = this.then(
    Modifier.drawBehind {
        val fw = frameThickness.toPx()
        val outer = Rect(0f, 0f, size.width, size.height)
        val inner = Rect(fw, fw, size.width - fw, size.height - fw)
        val r = innerCornerRadius.toPx()
            .coerceAtMost(inner.width / 6f)
            .coerceAtMost(inner.height / 6f)
        val inner2 = buildRectWithProtrudingSquarePathCompose(
            rectWidth = inner.width,
            rectHeight = inner.height - inner.width/4,
            squareSize = inner.width/4,
            padding = fw,
            rectTopRadius = r,
            squareRadius = r,
            jointRadius = r,
            rectBottomLeftRadius = r
        )
        val path = Path().apply {
            fillType = PathFillType.EvenOdd
            addRect(outer)
            addPath(inner2)
        }
        drawPath(path = path, color = color)
    }
)

fun buildRectWithProtrudingSquarePathCompose(
    rectWidth: Float,            // W
    rectHeight: Float,           // H
    squareSize: Float,           // S
    padding: Float,              // P
    rectTopRadius: Float,        // rr (TL & TR)
    squareRadius: Float,         // rs (2 góc dưới ô vuông)
    jointRadius: Float,          // rj (góc nối trên-trái ô vuông)
    rectBottomLeftRadius: Float  // rbl (góc BL chữ nhật)
): Path {
    require(squareSize <= rectWidth) { "squareSize phải ≤ rectWidth." }

    val W = rectWidth
    val H = rectHeight
    val S = squareSize
    val P = padding

    // Clamp bán kính an toàn
    val rr  = rectTopRadius.coerceAtMost(min(W, H) / 2f)
    val rs  = squareRadius.coerceAtMost(S / 2f)
    val rj  = jointRadius.coerceAtMost(min(S, W))         // bo nối không vượt kích thước logic
    val rbl = rectBottomLeftRadius.coerceAtMost(min(W, H) / 2f)

    // Toạ độ cơ sở (đã cộng padding)
    val x0 = P
    val y0 = P
    val xR = x0 + W               // mép phải chữ nhật
    val yB = y0 + H               // đáy chữ nhật
    val xLsq = xR - S             // mép trái ô vuông
    val yTsq = yB                 // đỉnh ô vuông
    val yBsq = yB + S             // đáy ô vuông

    return Path().apply {
        // Bắt đầu ở cạnh trên, cách rr để chuẩn bị bo TL khi khép
        moveTo(x0 + rr, y0)

        // Cạnh trên tới gần TR
        lineTo(xR - rr, y0)
        // Bo TR: cung 1/4 tròn trong rect [xR-2rr, y0, xR, y0+2rr], từ -90° -> 0°
        if (rr > 0f) {
            arcTo(
                rect = Rect(xR - 2*rr, y0, xR, y0 + 2*rr),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        } else {
            lineTo(xR, y0)
        }

        // Mép phải xuống đáy chữ nhật
        lineTo(xR, yB)

        // Mép phải ô vuông xuống tới trước góc BR ô vuông
        if (rs > 0f) {
            lineTo(xR, yBsq - rs)
            // Bo BR ô vuông: rect [xR-2rs, yBsq-2rs, xR, yBsq], 0° -> 90°
            arcTo(
                rect = Rect(xR - 2*rs, yBsq - 2*rs, xR, yBsq),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        } else {
            lineTo(xR, yBsq)
        }

        // Đáy ô vuông sang trái tới trước góc BL ô vuông
        if (rs > 0f) {
            lineTo(xLsq + rs, yBsq)
            // Bo BL ô vuông: rect [xLsq, yBsq-2rs, xLsq+2rs, yBsq], 90° -> 180°
            arcTo(
                rect = Rect(xLsq, yBsq - 2*rs, xLsq + 2*rs, yBsq),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        } else {
            lineTo(xLsq, yBsq)
        }

        // Lên cạnh trái ô vuông tới gần điểm nối (để bo joint)
        if (rj > 0f) {
            lineTo(xLsq, yTsq + rj)
            // Bo góc nối (trên-trái ô vuông):
            // oval rect [xLsq-2rj, yTsq, xLsq, yTsq+2rj], đi từ 0° (phải) -> -90° (trên), sweep âm
            arcTo(
                rect = Rect(xLsq - 2*rj, yTsq, xLsq, yTsq + 2*rj),
                startAngleDegrees = 0f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false
            )
        } else {
            // không bo joint: góc vuông tại (xLsq, yTsq)
            lineTo(xLsq, yTsq)
        }

        // Đáy chữ nhật sang trái tới gần góc BL để bo
        if (rbl > 0f) {
            lineTo(x0 + rbl, yB)
            // Bo BL chữ nhật: rect [x0, yB-2rbl, x0+2rbl, yB], 90° -> 180°
            arcTo(
                rect = Rect(x0, yB - 2*rbl, x0 + 2*rbl, yB),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        } else {
            lineTo(x0, yB)
        }

        // Lên cạnh trái tới gần TL để bo
        lineTo(x0, y0 + rr)
        // Bo TL: rect [x0, y0, x0+2rr, y0+2rr], 180° -> 270°
        if (rr > 0f) {
            arcTo(
                rect = Rect(x0, y0, x0 + 2*rr, y0 + 2*rr),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        } else {
            lineTo(x0, y0)
        }

        close()
    }
}

package com.yifan.overscroll

import android.util.Log
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import com.google.android.material.math.MathUtils.lerp

internal class OverscrollGraphicsLayerModifier(
    private val overScrollState: OverScrollState,
    private val maxOffset: Float = overScrollState.maxOffset,
    private val maxScaleMultiple: Float = 1.0f,
    private val maxParallaxOffset: Float = 100f,
    private val finalAlpha: Float = 1.0f,
    private val rotationMultiple: Float = 0f,
    private val effect: OverScrollEffect = OverScrollEffect.Scale
) : LayoutModifier {

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        val offset = overScrollState.offSet
        val process = offset / maxOffset

        var newScale = 1.0f
        var newTranslationY = 0f
        var newTranslationX = 0f
        var newAlpha = 1.0f
        var newRotationZ = 0f
        var newRotationX = 0f
        var newRotationY = 0f

        Log.i("yifan", "process : $process")
        when (effect) {
            OverScrollEffect.Scale -> {
                newScale = lerp(1.0f, maxScaleMultiple, process)
                newTranslationX = (placeable.width * (newScale - 1)) / 2
                newTranslationY = (placeable.height * (newScale - 1)) / 2
            }
            OverScrollEffect.ScaleCenter -> {
                newScale = lerp(1.0f, maxScaleMultiple, process)
            }
            OverScrollEffect.ParallaxVertical -> {
                newTranslationY = lerp(0f, maxParallaxOffset, process)
            }
            OverScrollEffect.ParallaxHorizontal -> {
                newTranslationX = lerp(0f, maxParallaxOffset, process)
            }
            OverScrollEffect.Header -> {
                newScale = (placeable.height + offset) / placeable.height
                newTranslationY = offset / 2
            }
            OverScrollEffect.Alpha -> {
                newAlpha = lerp(1.0f, finalAlpha, process)
            }
            OverScrollEffect.RotationCenter -> {
                newRotationZ = lerp(0f, rotationMultiple * 360, process)
            }
            OverScrollEffect.RotationHorizontal -> {
                newRotationY = lerp(0f, rotationMultiple * 360, process)
            }
            OverScrollEffect.RotationVertical -> {
                newRotationX = lerp(0f, rotationMultiple * 360, process)
            }
        }
        val newHeight = placeable.height * newScale
        val layerBlock: GraphicsLayerScope.() -> Unit = {
            scaleX = newScale
            scaleY = newScale
            translationY = newTranslationY
            translationX = newTranslationX
            alpha = newAlpha
            rotationZ = newRotationZ
            rotationX = newRotationX
            rotationY = newRotationY
        }
        return layout(placeable.width, newHeight.toInt()) {
            placeable.placeWithLayer(0, 0, layerBlock = layerBlock)
        }
    }
}
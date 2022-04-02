package com.yifan.overscroll

import androidx.compose.ui.Modifier

fun Modifier.overScrollScale(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    maxScaleMultiple: Float = 1.5f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        maxScaleMultiple = maxScaleMultiple,
        effect = OverScrollEffect.Scale
    )
)

fun Modifier.overScrollScaleCenter(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    maxScaleMultiple: Float = 1.5f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        maxScaleMultiple = maxScaleMultiple,
        effect = OverScrollEffect.ScaleCenter
    )
)

fun Modifier.overScrollParallaxVertical(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    maxParallaxOffset: Float = 100f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        maxParallaxOffset = maxParallaxOffset,
        effect = OverScrollEffect.ParallaxVertical
    )
)

fun Modifier.overScrollParallaxHorizontal(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    maxParallaxOffset: Float = 100f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        maxParallaxOffset = maxParallaxOffset,
        effect = OverScrollEffect.ParallaxHorizontal
    )
)

fun Modifier.overScrollAlpha(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    finalAlpha: Float = 0f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        finalAlpha = finalAlpha,
        effect = OverScrollEffect.Alpha
    )
)

fun Modifier.overScrollRotationCenter(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    rotationMultiple: Float = 1f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        rotationMultiple = rotationMultiple,
        effect = OverScrollEffect.RotationCenter
    )
)

fun Modifier.overScrollRotationVertical(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    rotationMultiple: Float = 1f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        rotationMultiple = rotationMultiple,
        effect = OverScrollEffect.RotationVertical
    )
)

fun Modifier.overScrollRotationHorizontal(
    overScrollState: OverScrollState,
    maxOffset: Float = overScrollState.maxOffset,
    rotationMultiple: Float = 1f
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        maxOffset = maxOffset,
        rotationMultiple = rotationMultiple,
        effect = OverScrollEffect.RotationHorizontal
    )
)

fun Modifier.overScrollHeader(
    overScrollState: OverScrollState,
    headerHeight: Float = DefaultHeaderHeight,
) = this.then(
    OverscrollGraphicsLayerModifier(
        overScrollState = overScrollState,
        headerHeight = headerHeight,
        effect = OverScrollEffect.Header
    )
)
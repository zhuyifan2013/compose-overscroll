# OverScroll for Compose

Easy to use but very powerful component to create over scroll effects for any composables. 

- Compose style API, only 3 lines to use.
- Built-in effects: Scale, Parallax, Alpha, Rotation, Header and EmptyHeader.
- Combine multiple effects with only one line code.
- Support custom animation.
- Expose over scroll meta data (offset and progress) for advanced usage.

# Usage
Declare a `OverScrollState`, it contains over scroll meta data:

```kotlin
var state: OverScrollState = remember { OverScrollState() }
```

Wrap your composable into `OverScroll`

```kotlin
OverScroll(overScrollState = { state = it }) {
    YourComposable(){}
}
```

Add built-in modifiers to any composable as you wish, pass `state` to as parameter: 
```kotlin
OverScroll(overScrollState = { state = it }) {
    YourComposable(){
        Box(
            modifier = Modifier
                .overScrollHeader(state)
        )
    }
}
```

# API
`OverScrollState` is the fundamental but important concept, it contains `offSet`, which indicates what offSet (in pixels) you over scroll down, and `progress`, which indicates what percentage you over scroll based on `maxOffset` (Default is 400f pixels)

For most basic usages, this library provides some useful modifiers, you could chain to any modifier in any Composables.

### `OverScroll` Composable

- maxOffset :  The max offset when over scrolling.
- animationSpec :  An instance of `AnimationSpec`, it decides how the offset value changes, default is `SpringSpec`

### `Modifier.overScrollHeader`

A speciall but useful modifier when you want your header composable follows down when over scroll. It is the most outter  header container typically.

-  headerHeight : Must specify a header height, default 


### `Modifier.overScrollScale`

Scale composable when over scrolling.

-  maxScaleMultiple : The max scale multiple when you over scroll to the max offset.

### `Modifier.overScrollScaleCenter`

Scale composable from center pivot  when over scrolling.

-  maxScaleMultiple : The max scale multiple when you over scroll to the max offset.

### `Modifier.overScrollParallaxVertical`

Create Parallax effect for composable when over scrolling.

-  maxParallaxOffset : The max translation vertically when you over scroll to the max offset.

### `Modifier.overScrollParallaxHorizontal`

Create Parallax effect for composable when over scrolling.

-  maxParallaxOffset : The max translation horizontally when you over scroll to the max offset.

### `Modifier.overScrollAlpha`

Create alpha effect for composable when over scrolling.

-  finalAlpha : The final alpha value you want when you over scroll to the max offset.

### `Modifier.overScrollRotationCenter`

Rotate composable when over scrolling based on Z-axis.

-  rotationMultiple : `1` means you want to rotate 360 degress when you over scroll to the max offset.


### `Modifier.overScrollRotationVertical`

Rotate composable when over scrolling based on X-axis.

-  rotationMultiple : `1` means you want to rotate 360 degress when you over scroll to the max offset.

### `Modifier.overScrollRotationHorizontal`

Rotate composable when over scrolling based on Y-axis.

-  rotationMultiple : `1` means you want to rotate 360 degress when you over scroll to the max offset.


# Sample
All samples could be found here
## Header
## Empty Header
## Scale
## Parallax
## Alpha
## Rotation
## Combine effects
## Custom animation
## Advanced usage

# License


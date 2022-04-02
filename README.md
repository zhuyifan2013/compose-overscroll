![黑白立体格子简约LinkedIn Banner (2)](https://user-images.githubusercontent.com/3753079/161373650-8e533f1a-e047-4da1-b5d0-eb29b54a7d12.png)


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

# Sample
All samples could be found in `sample` module.

|Header|LazyColumn|Parallax|Scale|
|------|----------|--------|-----|
|![2022-04-02 15 42 38 3](https://user-images.githubusercontent.com/3753079/161372784-45e79714-39c2-4bb8-86dd-640414d06856.gif)|![2022-04-02 15 42 38 7](https://user-images.githubusercontent.com/3753079/161372773-c714b999-6dd6-4744-8f90-b1ae4ab0a183.gif)|![2022-04-02 15 42 38 8](https://user-images.githubusercontent.com/3753079/161372763-bce242b4-e788-4ad3-bcc5-db7ed3a45fed.gif)|![2022-04-02 15 42 38 9](https://user-images.githubusercontent.com/3753079/161372825-8807a4db-de9b-4e9b-8434-784ab63d352f.gif)|

|Rotation|Combine|EmptyHeader|CustomAnimation1|
|------|----------|----------|----------------|
|![2022-04-02 15 42 38 5](https://user-images.githubusercontent.com/3753079/161372867-5a4e3e89-8dd7-4415-a410-d88f7d0bca13.gif)|![2022-04-02 15 42 38 4](https://user-images.githubusercontent.com/3753079/161372869-df4eb9ea-c57b-4068-a0e5-7d1ec1ee2716.gif)|![2022-04-02 15 42 38 3](https://user-images.githubusercontent.com/3753079/161372877-53e2a6bc-7f6c-4772-b614-e5ace778cf47.gif)|![2022-04-02 15 42 38 2](https://user-images.githubusercontent.com/3753079/161372882-8a83945f-0022-4918-b8b5-9863c24399b1.gif)|


|CustomAnimation2|Advanced|
|----------------|--------|
|![2022-04-02 15 42 38 1](https://user-images.githubusercontent.com/3753079/161372912-654522f0-21a3-4f6f-acf8-394e13e6c3d0.gif)|![2022-04-02 15 42 38 0](https://user-images.githubusercontent.com/3753079/161372920-75f3c96a-e5d9-469b-888c-c773c028df00.gif)|



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


# License

Copyright 2022 Yifan Zhu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Source: http://opensource.org/licenses/Apache-2.0


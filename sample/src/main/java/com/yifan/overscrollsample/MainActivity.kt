package com.yifan.overscrollsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yifan.overscroll.*

enum class Example {
    OverScrollHeader,
    OverScrollLazyColumn,
    OverScrollParallax,
    OverScrollScale,
    OverScrollRotation,
    OverScrollCombine,
    OverScrollEmptyHeader,
    OverScrollCustomAnimation1,
    OverScrollCustomAnimation2,
    OverScrollAdvanced
}

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                enumValues<Example>().forEach { it ->
                    ListItem(modifier = Modifier.clickable {
                        openDemoPage(it)
                    }, text = { Text(it.name) })
                }
            }
        }
    }

    private fun openDemoPage(example: Example) {
        startActivity(Intent(this, SampleActivity::class.java).putExtra("sample_id", example))
    }
}


class SampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sample = intent.extras?.get("sample_id") ?: Example.OverScrollHeader

        setContent {
            when (sample) {
                Example.OverScrollHeader -> OverScrollHeader()
                Example.OverScrollLazyColumn -> OverScrollLazyColumn()
                Example.OverScrollParallax -> OverScrollParallax()
                Example.OverScrollScale -> OverScrollScale()
                Example.OverScrollRotation -> OverScrollRotation()
                Example.OverScrollCombine -> OverScrollCombine()
                Example.OverScrollEmptyHeader -> OverScrollEmptyHeader()
                Example.OverScrollCustomAnimation1 -> OverScrollCustomAnimation1()
                Example.OverScrollCustomAnimation2 -> OverScrollCustomAnimation2()
                Example.OverScrollAdvanced -> OverScrollAdvanced()
                else -> OverScrollHeader()
            }
        }
    }

}

@Composable
fun OverScrollHeader() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(R.drawable.spiderman),
                contentDescription = null,
                modifier = Modifier
                    .overScrollHeader(state)
                    .height(300.dp)
                    .layoutId("image"),
                contentScale = ContentScale.Crop
            )
            repeat(20) {
                SampleItem()
            }
        }

    }
}

@Composable
fun OverScrollLazyColumn() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.spiderman),
                    contentDescription = null,
                    modifier = Modifier
                        .overScrollHeader(state)
                        .height(300.dp)
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollParallax() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Box {
                    Image(
                        painter = painterResource(R.drawable.spiderman),
                        contentDescription = null,
                        modifier = Modifier
                            .overScrollHeader(state)
                            .height(300.dp)
                            .layoutId("image"),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp, top = 70.dp)) {
                        Button(
                            onClick = {},
                            modifier = Modifier.overScrollParallaxVertical(state, maxParallaxOffset = 100f)
                        ) {
                            Text("Parallax default")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollParallaxVertical(state, maxParallaxOffset = 200f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Parallax 200")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollParallaxVertical(state, maxParallaxOffset = 300f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Parallax 300")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollParallaxHorizontal(state)
                                .padding(top = 10.dp)
                        ) {
                            Text("Parallax Horizontal default")
                        }
                    }

                }

            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollScale() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Box {
                    Image(
                        painter = painterResource(R.drawable.spiderman),
                        contentDescription = null,
                        modifier = Modifier
                            .overScrollHeader(state)
                            .height(300.dp)
                            .layoutId("image"),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp, top = 70.dp)) {
                        Button(
                            onClick = {},
                            modifier = Modifier.overScrollScale(state)
                        ) {
                            Text("Scale default")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollScale(state, maxScaleMultiple = 1.2f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Scale 1.2")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollScale(state, maxScaleMultiple = 2.5f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Scale 2.5")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollScaleCenter(state, maxScaleMultiple = 2.5f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Scale center 2.5")
                        }
                    }

                }

            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollRotation() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Box {
                    Image(
                        painter = painterResource(R.drawable.spiderman),
                        contentDescription = null,
                        modifier = Modifier
                            .overScrollHeader(state)
                            .height(300.dp)
                            .layoutId("image"),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp, top = 70.dp)) {
                        Button(
                            onClick = {},
                            modifier = Modifier.overScrollRotationCenter(state)
                        ) {
                            Text("Rotation center default")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollRotationCenter(state, rotationMultiple = 2.0f)
                                .padding(top = 10.dp)
                        ) {
                            Text("Rotation center 2")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollRotationHorizontal(state)
                                .padding(top = 10.dp)
                        ) {
                            Text("RotationHorizontal default")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollRotationVertical(state)
                                .padding(top = 10.dp)
                        ) {
                            Text("overScrollRotationVertical default")
                        }
                    }

                }

            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollCombine() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Box {
                    Image(
                        painter = painterResource(R.drawable.spiderman),
                        contentDescription = null,
                        modifier = Modifier
                            .overScrollHeader(state)
                            .height(300.dp)
                            .layoutId("image"),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 70.dp)
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollScale(state)
                                .overScrollAlpha(state)

                        ) {
                            Text("Alpha and Scale")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .overScrollParallaxHorizontal(state)
                                .overScrollAlpha(state)
                                .padding(top = 20.dp)
                        ) {
                            Text("Scale and Parallax")
                        }

                    }

                }

            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollEmptyHeader() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(overScrollState = { state = it }) {
        LazyColumn(modifier = Modifier.overScrollParallaxVertical(state, maxParallaxOffset = 800f)) {
            item {
                Image(
                    painter = painterResource(R.drawable.spiderman),
                    contentDescription = null,
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollCustomAnimation1() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(
        overScrollState = { state = it },
        animationSpec = SpringSpec(stiffness = 50f)
    ) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(R.drawable.spiderman),
                    contentDescription = null,
                    modifier = Modifier
                        .overScrollHeader(state)
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            items(20) {
                SampleItem()
            }
        }
    }
}

@Composable
fun OverScrollCustomAnimation2() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(
        overScrollState = { state = it },
        animationSpec = SpringSpec(dampingRatio = Spring.DampingRatioHighBouncy)
    ) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(R.drawable.spiderman),
                    contentDescription = null,
                    modifier = Modifier
                        .overScrollHeader(state)
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            items(20) {
                SampleItem()
            }
        }
    }
}
@Preview
@Composable
fun OverScrollAdvanced() {
    var state: OverScrollState = remember {
        OverScrollState()
    }
    OverScroll(
        overScrollState = { state = it },
    ) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(R.drawable.spiderman),
                    contentDescription = null,
                    modifier = Modifier
                        .overScrollHeader(state)
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            items(20) { index ->
                val maxSpacer = index * 30 / 20f
                Column {
                    SampleItem(narutoItem = narutos[index % narutos.size], height = (maxSpacer * state.progress).dp)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SampleItem(modifier: Modifier = Modifier, narutoItem: NarutoItem = narutos[0], height: Dp = 0.dp) {
    ListItem(text = { Text(narutoItem.name) },
        icon = {
            Image(painter = painterResource(narutoItem.image), contentDescription = narutoItem.name)
        })
    Divider(modifier = Modifier.padding(horizontal = 30.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(Color.Gray)
    )
}
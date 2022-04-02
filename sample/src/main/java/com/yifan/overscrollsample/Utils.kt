package com.yifan.overscrollsample

import androidx.annotation.DrawableRes

data class NarutoItem(val name: String, @DrawableRes val image: Int)

val narutos = listOf(
    NarutoItem("Boruto", R.drawable.boruto_uzumaki),
    NarutoItem("Hinata", R.drawable.hinata),
    NarutoItem("Itachi", R.drawable.itachi_uchiha),
    NarutoItem("Kakashi", R.drawable.kakashi_hatake),
    NarutoItem("Naruto", R.drawable.naruto),
    NarutoItem("Obito", R.drawable.obito_uchiha),
    NarutoItem("Sarada", R.drawable.sarada_uchiha),
    NarutoItem("Sasuke", R.drawable.sasuke_uchiha),
    NarutoItem("Tsunade", R.drawable.tsunade)

)


class Utils {
}
package com.hikam.karaktergenshin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakter(
    val name: String,
    val description: String,
    val photo: Int,
    val vision: String,
    val img_vision: Int,
    val region: String,
    val img_region: Int
) : Parcelable


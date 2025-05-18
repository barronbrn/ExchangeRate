package com.example.exchangerate.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country (
    val flag: Int,
    val countryName: String,
    val buy: String,
    val sell: String
) : Parcelable

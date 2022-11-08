package com.example.acronyms.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meaning(
    @Json(name = "lf")
    val longForm: String,
    @Json(name = "freq")
    val frequency: Long,
    @Json(name = "since")
    val since: Long
): Parcelable
package com.example.acronyms.network

import android.os.Parcelable
import com.example.acronyms.data.Meaning
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MeaningsProperty(
    @Json(name = "sf")
    val shortForm: String,
    @Json(name = "lfs")
    val longForms: List<Meaning>
): Parcelable
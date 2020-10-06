package com.mitocode.taller2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumModel(
    var id: Int,
    var title: String? = null
) : Parcelable
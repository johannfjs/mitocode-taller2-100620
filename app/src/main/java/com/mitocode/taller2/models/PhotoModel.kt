package com.mitocode.taller2.models

data class PhotoModel(
    var id: Int,
    var albumId: Int,
    var title: String? = null,
    var url: String? = null,
    var thumbnailUrl: String? = null
) {
}
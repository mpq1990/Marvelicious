package com.example.android.marvelicious.util

import com.example.android.marvelicious.domain.Models

fun generateThumbnailLink(image: Models.Image, type: MarvelImageTypes): String {
    return image.path + "/${type.type}" + "." + image.extension
}

enum class MarvelImageTypes(val type: String) {
    PORTRAIT_SMALL("portrait_small"),
    PORTRAIT_MEDIUM("portrait_medium"),
    PORTRAIT_XLARGE("portrait_xlarge"),
    PORTRAIT_FANTASTIC("portrait_fantastic"),
    PORTRAIT_UNCANNY("portrait_uncanny"),
    PORTRAIT_INCREDIBLE("portrait_incredible"),
    STANDARD_SMALL("standard_small"),
    STANDARD_MEDIUM("standard_medium"),
    STANDARD_LARGE("standard_large"),
    STANDARD_XLARGE("standard_xlarge"),
    STANDARD_FANTASTIC("standard_fantastic"),
    STANDARD_AMAZING("standard_amazing"),
    LANDSCAPE_SMALL("landscape_small"),
    LANDSCAPE_MEDIUM("landscape_medium"),
    LANDSCAPE_LARGE("landscape_large"),
    LANDSCAPE_XLARGE("landscape_xlarge"),
    LANDSCAPE_AMAZING("landscape_amazing"),
    LANDSCAPE_INCREDIBLE("landscape_incredible")
}
package com.nech9ev.core

enum class GifCategory: GifCategoryValue {
    LATEST {
        override fun getValue() = "latest"
    }, HOT {
        override fun getValue() = "hot"
    }, TOP {
        override fun getValue() = "top"
    }
}
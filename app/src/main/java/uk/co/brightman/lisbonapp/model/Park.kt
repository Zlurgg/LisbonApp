package uk.co.brightman.lisbonapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Park (
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val image: Int
)
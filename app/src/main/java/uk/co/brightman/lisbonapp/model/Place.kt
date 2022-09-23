package uk.co.brightman.lisbonapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


sealed class Place(
    open val name: Int,
    open val image: Int,
) {
    /**
     * Getter method for places.
     */
    data class Restaurant(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int
    ) : Place(name, image)
}

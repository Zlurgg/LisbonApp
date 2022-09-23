package uk.co.brightman.lisbonapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


sealed class Places(
    open val name: Int,
    open val image: Int,
    open val category: String,
) {
    /**
     * Getter method for places.
     */
    data class Place(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        override val category: String
    ) : Places(name, image, category)
}

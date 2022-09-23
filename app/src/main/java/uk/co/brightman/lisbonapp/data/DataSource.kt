package uk.co.brightman.lisbonapp.data

import uk.co.brightman.lisbonapp.R
import uk.co.brightman.lisbonapp.model.Places.Place

/**
 * Just a dummy data class to hold the lists of places
 */
object DataSource {
    val restaurants = listOf(
        Place(
            name = R.string.sucolento,
            image = R.drawable.sucolento,
            category = "restaurant"
        ),
        Place(
            name = R.string.yallah_lisboa,
            image = R.drawable.yallah_lisboa,
            category = "restaurant"
        ),
        Place(
            name = R.string.frade_dos_mares,
            image = R.drawable.frade_dos_mares,
            category = "restaurant"
        ),
        Place(
            name = R.string.cafe_de_sao_bento,
            image = R.drawable.caf__de_s_o_bento,
            category = "restaurant"
        ),
        Place(
            name = R.string.armaha,
            image = R.drawable.armaha,
            category = "restaurant"
        )
    )
    val bars = listOf(
        Place(
            name = R.string.the_bar,
            image = R.drawable.the_bar,
            category = "bar"
        ),
        Place(
            name = R.string.social_b,
            image = R.drawable.social_b,
            category = "bar"
        ),
        Place(
            name = R.string.cinco_lounge,
            image = R.drawable.cinco_lounge,
            category = "bar"
        ),
        Place(
            name = R.string.imprensa_cocktail_and_oyster_bar,
            image = R.drawable.imprensa_cocktail_and_oyster_bar,
            category = "bar"
        ),
        Place(
            name = R.string.mignon_sports_bar,
            image = R.drawable.mignon_sports_bar,
            category = "bar"
        )
    )
}
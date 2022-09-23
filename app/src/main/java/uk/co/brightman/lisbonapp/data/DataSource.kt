package uk.co.brightman.lisbonapp.data

import uk.co.brightman.lisbonapp.R
import uk.co.brightman.lisbonapp.model.Place.Restaurant

object DataSource {
    val restaurants = listOf(
        Restaurant(
            name = R.string.sucolento,
            image = R.drawable.sucolento
        ),
        Restaurant(
            name = R.string.yallah_lisboa,
            image = R.drawable.yallah_lisboa
        ),
        Restaurant(
            name = R.string.frade_dos_mares,
            image = R.drawable.frade_dos_mares
        ),
        Restaurant(
            name = R.string.cafe_de_sao_bento,
            image = R.drawable.caf__de_s_o_bento
        ),
        Restaurant(
            name = R.string.armaha,
            image = R.drawable.armaha
        )
    )
}
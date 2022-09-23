package uk.co.brightman.lisbonapp

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.co.brightman.lisbonapp.ui.LisbonViewModel

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Restaurant(title = R.string.restaurant_title),
}

/**
 * Main composable that serves as container
 * which displays content
 */
@Composable
fun LisbonApp(
    modifier: Modifier = Modifier,
    viewModel: LisbonViewModel = viewModel(),
    navController: NavHostController = rememberNavController()) {
}
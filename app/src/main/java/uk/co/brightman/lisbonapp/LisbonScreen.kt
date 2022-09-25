package uk.co.brightman.lisbonapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import uk.co.brightman.lisbonapp.data.DataSource
import uk.co.brightman.lisbonapp.ui.LisbonViewModel
import uk.co.brightman.lisbonapp.ui.PlaceScreen
import uk.co.brightman.lisbonapp.ui.WhereToNextScreen

/**
 * enum values that represent the screens in the app
 */
enum class LisbonScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    WhereToScreen(title = R.string.where_to_go),
    Restaurant(title = R.string.restaurant_title),
    Bar(title = R.string.bar_title),
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun LisbonAppBar(
    currentScreen: LisbonScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

/**
 * Main composable that serves as container
 * which displays content
 */
@Composable
fun LisbonApp(
    modifier: Modifier = Modifier
) {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = LisbonScreen.valueOf(
        backStackEntry?.destination?.route ?: LisbonScreen.Home.name
    )
    // Create ViewModel
    val viewModel: LisbonViewModel = viewModel()
    Scaffold(
        topBar = {
            LisbonAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
//        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = LisbonScreen.Home.name,
            modifier = modifier.padding(innerPadding),
        ) {
            composable(route = LisbonScreen.Home.name) {
                WhereToNextScreen(
                    whereToNextScreen = {
                        whereToNext(navController)
                    }
                )
            }

            /**
             * So should be able to change this, all of these are places; no need to have separate calls for restaurant, bar etc
             * instead have one Place screen that gets the correct data
             * so need to pass the selection (from the random int) to the PlaceScreen (this change be refactored from RestaurantScreen
             * likewise no need for multiple composable functions here as they are all going to call the same screen Place
             */

            composable(route = LisbonScreen.Restaurant.name) {
                PlaceScreen(
                    restaurants = DataSource.restaurants,
                    onCancelButtonClicked = {
//                        viewModel.resetOrder()
                        navController.popBackStack(LisbonScreen.Home.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        whereToNext(navController)
                    },
/*                    onSelectionChanged = {
                        item -> viewModel.updateEntree(item)
                    }*/
                )
            }
            composable(route = LisbonScreen.Bar.name) {
                PlaceScreen(
                    restaurants = DataSource.bars,
                    onCancelButtonClicked = {
//                        viewModel.resetOrder()
                        navController.popBackStack(LisbonScreen.Home.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        whereToNext(navController)
                    },
/*                    onSelectionChanged = {
                        item -> viewModel.updateEntree(item)
                    }*/
                )
            }
        }
    }
}

fun whereToNext(navController: NavController) {
    when ((1..4).random()) {
        0 -> navController.navigate(LisbonScreen.Restaurant.name)
                            1 -> navController.navigate(LisbonScreen.Bar.name)
//                            2 -> navController.navigate(LisbonScreen.CoffeeShop.name)
//                            3 -> navController.navigate(LisbonScreen.Park.name)
//                            4 -> navController.navigate(LisbonScreen.Museum.name)
        else -> navController.navigate(LisbonScreen.Restaurant.name)
    }
}

package uk.co.brightman.lisbonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uk.co.brightman.lisbonapp.R
import uk.co.brightman.lisbonapp.model.Places.Place

@Composable
fun RestaurantsScreen(
    restaurants: List<Place>,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
//    onSelectionChanged: (Restaurant) -> Unit,
    modifier: Modifier = Modifier
) {

    var selectedRestaurantName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        restaurants.forEach { restaurant ->
            val restaurantName = stringResource(id = restaurant.name)
            RestaurantRow(
                restaurant = restaurant,
                selectedRestaurantName = selectedRestaurantName,
                onSelectionRestaurantChanged = {
                    selectedRestaurantName =
                        restaurantName
                },
//                onSelectionChanged = onSelectionChanged
            )
        }

        RestaurantScreenButtonGroup(
            selectedRestaurantName = selectedRestaurantName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = {
                // Assert not null bc next button is not enabled unless selectedItem is not null.
                onNextButtonClicked()
            }
        )
    }
}

@Composable
fun RestaurantRow(
    restaurant: Place,
    selectedRestaurantName: String,
    onSelectionRestaurantChanged: (String) -> Unit,
//    onSelectionChanged: (Restaurant) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(id = restaurant.name),
            style = MaterialTheme.typography.h6
        )
        Image(
            painter = painterResource(restaurant.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Divider(
            thickness = 1.dp,
            modifier = modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun RestaurantScreenButtonGroup(
    selectedRestaurantName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text(stringResource(R.string.cancel).uppercase())
        }
        Button(
            modifier = Modifier.weight(1f),
            // the button is enabled when the user makes a selection
            enabled = selectedRestaurantName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next).uppercase())
        }
    }
}
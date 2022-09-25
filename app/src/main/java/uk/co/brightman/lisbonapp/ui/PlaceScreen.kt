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
fun PlaceScreen(
    restaurants: List<Place>,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
//    onSelectionChanged: (Restaurant) -> Unit,
    modifier: Modifier = Modifier
) {

    var selectedPlaceName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        restaurants.forEach { place ->
            val placeName = stringResource(id = place.name)
            PlaceRow(
                place = place,
                selectedPlaceName = selectedPlaceName,
                onSelectionPlaceChanged = {
                    selectedPlaceName =
                        placeName
                },
//                onSelectionChanged = onSelectionChanged
            )
        }

        PlaceScreenButtonGroup(
            selectedPlaceName = selectedPlaceName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = {
                // Assert not null bc next button is not enabled unless selectedItem is not null.
                onNextButtonClicked()
            }
        )
    }
}

@Composable
fun PlaceRow(
    place: Place,
    selectedPlaceName: String,
    onSelectionPlaceChanged: (String) -> Unit,
//    onSelectionChanged: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(id = place.name),
            style = MaterialTheme.typography.h6
        )
        Image(
            painter = painterResource(place.image),
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
fun PlaceScreenButtonGroup(
    selectedPlaceName: String,
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
        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = onCancelButtonClicked
        ) {
            Text(stringResource(R.string.cancel).uppercase())
        }
        Button(
            modifier = Modifier.weight(1f),
            // the button is enabled when the user makes a selection
            enabled = selectedPlaceName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next).uppercase())
        }
    }
}
package uk.co.brightman.lisbonapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.brightman.lisbonapp.R

@Composable
fun WhereToNextScreen(
    whereToNextScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = whereToNextScreen,
            modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.where_to_go))
        }
    }
}

@Preview
@Composable
fun WhereToNextPreviewScreen(){
    WhereToNextScreen(whereToNextScreen = {})
}

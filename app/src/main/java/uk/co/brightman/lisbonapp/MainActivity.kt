package uk.co.brightman.lisbonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uk.co.brightman.lisbonapp.ui.theme.LisbonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LisbonTheme {
                LisbonApp()
            }
        }
    }
}
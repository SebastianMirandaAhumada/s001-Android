package s001_moile_sebastian.miranda.s001_sebastian_miranda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import s001_moile_sebastian.miranda.s001_sebastian_miranda.navigation.AppNavigation
import s001_moile_sebastian.miranda.s001_sebastian_miranda.screens.FirstScreen
import s001_moile_sebastian.miranda.s001_sebastian_miranda.ui.theme.S001_Sebastian_MirandaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S001_Sebastian_MirandaTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Surface(color = MaterialTheme.colorScheme.background) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AppNavigation()
}


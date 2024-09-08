package s001_moile_sebastian.miranda.s001_sebastian_miranda.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s001_moile_sebastian.miranda.s001_sebastian_miranda.R
import s001_moile_sebastian.miranda.s001_sebastian_miranda.navigation.AppScreens
import s001_moile_sebastian.miranda.s001_sebastian_miranda.store.UseApplication.Companion.prefs


@Composable
fun RecoveryScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        RecoveryBodyContent(navController )
    }
}

@Composable
fun RecoveryBodyContent(navController: NavController){

    val email = remember{ mutableStateOf("") }
    val passState = remember { mutableStateOf(("")) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Descripción de la imagen",
            modifier = Modifier.size(200.dp).padding(bottom = 16.dp)
        )
       TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = passState.value,
            onValueChange = { passState.value = it },
            label = { Text(text = "Escribe tu Nueva Contraseña") },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.padding(bottom = 16.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        prefs.savePass(passState.value)

        Button(onClick = {
            navController.navigate(AppScreens.FirstScreen.route)
        }) {
            Text(text = "Recuperar Contraseña")
        }


    }
}


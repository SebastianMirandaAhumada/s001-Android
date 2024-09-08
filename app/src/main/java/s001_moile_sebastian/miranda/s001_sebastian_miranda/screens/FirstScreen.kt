package s001_moile_sebastian.miranda.s001_sebastian_miranda.screens


import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun FirstScreen(navController: NavController){

    Column(modifier = Modifier.fillMaxSize()) {
    BodyContent(navController)
    }
}


@Composable
fun BodyContent(navController: NavController){

    val emailState = remember { mutableStateOf(("")) }
    val passState = remember { mutableStateOf(("")) }
    val passSave = prefs.getPass()
    val emailSave = prefs.getEmail()
    val errorMessage = remember { mutableStateOf("") }
    val context = LocalContext.current
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
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = passState.value,
            onValueChange = { passState.value = it },
            label = { Text(text = "Contraseña") },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        if (errorMessage.value.isNotEmpty()) {
            Text(
                text = errorMessage.value,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Row {
            Text(text = "Registrate",
                modifier = Modifier.clickable { navController.navigate(AppScreens.RegisterScreen.route) }
            )

            Text(text = "/", Modifier.padding(start = 8.dp, end  =8.dp))
            Text ( text= "Recuperar Contraseña",
                modifier = Modifier.clickable { navController.navigate(AppScreens.RecoveryScreen.route) }
                )
        }



        Button(onClick = {
            // Validación de email y contraseña
            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT




            if (emailState.value != emailSave || passState.value != passSave) { // Aquí "passwordFromPrefs" debe ser el valor real guardado
                Toast.makeText(context,"Email o contraseña incorrecta.",duration).show()

            } else {
                Toast.makeText(context,"Bienvenido", duration).show();
                navController.navigate(route = AppScreens.SecondScreen.route)
            }
        }) {
            Text(text = "Ingresar")
        }
    }
}


package s001_moile_sebastian.miranda.s001_sebastian_miranda.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import s001_moile_sebastian.miranda.s001_sebastian_miranda.navigation.AppScreens
import s001_moile_sebastian.miranda.s001_sebastian_miranda.store.UseApplication.Companion.prefs


@Composable
fun SecondScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        SecondBodyContent(navController )
        checkUserValue()
    }
}

fun checkUserValue(){
    if(prefs.getName().isNotEmpty()){

    }
}


@Composable
fun SecondBodyContent(navController: NavController){

    val userList = listOf(
        Pair("Juan", "juan@egmail.com"),
        Pair("Maria", "maria@gmail.com"),
        Pair("Carlos", "carlos@gmail.com"),
        Pair("Ana", "ana@gmail.com"),
        Pair("Luis", "luis@gmail.com")
    )

    val nameSave = prefs.getName()
    val emailSave = prefs.getEmail()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        userList.forEach{(name, email) ->
            Text(text = "Bienvenido ${name}")
            Text(text = "${email}")
        }
        Text(text = "Bienvenido ${nameSave}")
        Text(text = "${emailSave}")



        Button(onClick = {

            navController.navigate(AppScreens.FirstScreen.route)
        }) {
            Text(text = "Volver a Inicio")
        }
    }
}

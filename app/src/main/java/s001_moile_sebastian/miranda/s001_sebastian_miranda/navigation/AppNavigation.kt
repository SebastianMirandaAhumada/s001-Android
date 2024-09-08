package s001_moile_sebastian.miranda.s001_sebastian_miranda.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import s001_moile_sebastian.miranda.s001_sebastian_miranda.screens.FirstScreen
import s001_moile_sebastian.miranda.s001_sebastian_miranda.screens.RecoveryScreen
import s001_moile_sebastian.miranda.s001_sebastian_miranda.screens.RegisterScreen
import s001_moile_sebastian.miranda.s001_sebastian_miranda.screens.SecondScreen

@Composable
fun AppNavigation(){

    //Verifica en que estado de la navegacion estamos para asi poder navegar entre ellas
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route) {
            SecondScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }

        composable(route = AppScreens.RecoveryScreen.route) {
            RecoveryScreen(navController)
        }
    }

}
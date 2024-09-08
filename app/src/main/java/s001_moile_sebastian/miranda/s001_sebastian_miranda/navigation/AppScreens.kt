package s001_moile_sebastian.miranda.s001_sebastian_miranda.navigation

sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("firs_screen")
    object SecondScreen: AppScreens("second_screen")
    object RegisterScreen: AppScreens("register_screen")
    object RecoveryScreen: AppScreens("recovery_screen")

}
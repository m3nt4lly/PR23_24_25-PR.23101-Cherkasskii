package com.example.pr23_23101_fi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private object AppRoute {
    const val Onboarding = "onboarding"
    const val Login = "login"
    const val EmailCode = "email_code"
    const val CreatePassword = "create_password"
    const val CreateCard = "create_card"
    const val Dashboard = "dashboard"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        // Показываем заставку
        SplashScreen(onSplashComplete = { showSplash = false })
    } else {
        // Основная навигация
        NavHost(navController = navController, startDestination = AppRoute.Onboarding) {

            // 1. Онбординг (Onboard 1, 2, 3)
            composable(AppRoute.Onboarding) {
                OnboardingScreen(
                    onSkip = { navController.navigateSingleTopTo(AppRoute.Login) },
                    onFinish = { navController.navigateSingleTopTo(AppRoute.Login) }
                )
            }

            // 2. Вход и регистрация
            composable(AppRoute.Login) {
                LoginScreen(onNavigateToEmailCode = { navController.navigateSingleTopTo(AppRoute.EmailCode) })
            }

            // 3. Код из Email
            composable(AppRoute.EmailCode) {
                EmailCodeScreen(onNavigateToCreatePassword = { navController.navigateSingleTopTo(AppRoute.CreatePassword) })
            }

            // 4. Создание пароля
            composable(AppRoute.CreatePassword) {
                CreatePasswordScreen(onNavigateToCard = { navController.navigateSingleTopTo(AppRoute.CreateCard) })
            }

            // 5. Карта пациента
            composable(AppRoute.CreateCard) {
                CreatePatientCardScreen(onNavigateToMain = { navController.navigateSingleTopTo(AppRoute.Dashboard) })
            }

            // 6. Главный экран
            composable(AppRoute.Dashboard) {
                MainDashboardScreen()
            }
        }
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) {
    navigate(route) { launchSingleTop = true }
}
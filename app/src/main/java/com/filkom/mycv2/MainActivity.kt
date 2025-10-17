package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filkom.mycv2.data.UserData
import com.filkom.mycv2.screen.DaftarScreen
import com.filkom.mycv2.screen.DetailScreen
import com.filkom.mycv2.screen.LoginScreen
import com.filkom.mycv2.ui.theme.MyCV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCV2Theme {
                val navController = rememberNavController()
                val viewModel: UserViewModel = viewModel()
                val userViewModel: UserViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavDestination.login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(NavDestination.login) {
                            LoginScreen(
                                onLogin = { email, password ->
                                    val success = viewModel.login(email, password)
                                    if (success) {
                                        navController.navigate(NavDestination.detail)
                                    } else {
                                        // jika belum terdaftar → arahkan ke daftar
                                        navController.navigate(NavDestination.daftar)
                                    }
                                },
                                onDaftar = {
                                    navController.navigate(NavDestination.daftar)
                                }
                            )
                        }

                        composable(NavDestination.daftar) {
                            DaftarScreen(
                                onSimpan = { data: UserData ->
                                    viewModel.daftar(data)
                                    navController.navigate(NavDestination.detail)
                                }
                            )
                        }

                        composable(NavDestination.detail) {
                            DetailScreen(
                                userData = userViewModel.userData,
                                onBackToList = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                Scaffold { innerPadding ->
                    NavigationApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NavigationApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLogin = { email ->
                    // Kirim email dan nama default ke detail
                    navController.navigate("detail/---/UserLogin/$email/---")
                },
                onDaftar = {
                    navController.navigate("daftar")
                }
            )
        }
        composable("daftar") {
            DaftarScreen(
                onSimpan = { nim, nama, email, alamat ->
                    navController.navigate("detail/$nim/$nama/$email/$alamat")
                }
            )
        }
        composable(
            route = "detail/{nim}/{nama}/{email}/{alamat}",
            arguments = listOf(
                navArgument("nim") { type = NavType.StringType },
                navArgument("nama") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("alamat") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: "---"
            val nama = backStackEntry.arguments?.getString("nama") ?: "No Name"
            val email = backStackEntry.arguments?.getString("email") ?: "No Email"
            val alamat = backStackEntry.arguments?.getString("alamat") ?: "No Address"

            DetailScreen(
                nim = nim,
                nama = nama,
                email = email,
                alamat = alamat,
                onDaftar = {
                    navController.navigate("daftar")
                }
            )
        }
    }
}

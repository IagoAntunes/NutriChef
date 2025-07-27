package com.iagoaf.nutrichef

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.iagoaf.nutrichef.core.routes.AppRoutes
import com.iagoaf.nutrichef.core.ui.theme.NutriChefTheme
import com.iagoaf.nutrichef.src.auth.presentation.screen.LoginScreen
import com.iagoaf.nutrichef.src.auth.presentation.viewmodel.AuthViewModel
import com.iagoaf.nutrichef.src.auth.presentation.viewmodel.LoginViewModel
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.presentation.screen.HomeScreen
import com.iagoaf.nutrichef.src.home.presentation.viewmodel.HomeViewModel
import com.iagoaf.nutrichef.src.plateDetail.presentation.screen.PlateDetailScreen
import com.iagoaf.nutrichef.src.plateDetail.presentation.viewmodel.PlateDetailViewModel
import com.iagoaf.nutrichef.src.search.presentation.screen.SearchScreen
import com.iagoaf.nutrichef.src.search.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NutriChefTheme {
                val authViewModel: AuthViewModel = hiltViewModel()
                val isLogged = authViewModel.isUserLoggedIn.collectAsState()

                when (isLogged.value) {
                    null -> {
                        // Show splash screen or loading state
                    }

                    true -> {
                        AppNavHost(
                            navController = navController,
                            startDestination = AppRoutes.HOME,
                            authViewModel = authViewModel
                        )
                    }

                    false -> {
                        AppNavHost(
                            navController = navController,
                            startDestination = AppRoutes.LOGIN,
                            authViewModel = authViewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppRoutes.SEARCH) {
            val searchViewModel: SearchViewModel = hiltViewModel()
            val state = searchViewModel.state.collectAsState()
            SearchScreen(
                state = state.value,
                onBack = {
                    navController.popBackStack()
                },
                onFilter = {
                    searchViewModel.filter(it)
                },
                onClickReceipt = { dish ->
                    val jsonDish = Uri.encode(Gson().toJson(dish))
                    navController.navigate("${AppRoutes.PLATEDETAIL}/$jsonDish")
                }
            )
        }
        composable("${AppRoutes.PLATEDETAIL}/{dishJson}") { backStackEntry ->
            val dishJson = backStackEntry.arguments?.getString("dishJson")
            val dish = Gson().fromJson(dishJson, DishModel::class.java)
            val plateDetailViewModel: PlateDetailViewModel = hiltViewModel()
            val state = plateDetailViewModel.state.collectAsState()
            plateDetailViewModel.dish = dish
            PlateDetailScreen(
                state = state.value,
                dish = dish,
                onBack = { navController.popBackStack() },
                onClickShowDetails = {
                    plateDetailViewModel.changeState(it)
                },
                getProteinBars = {
                    plateDetailViewModel.getProteinBars()
                },
                getCarbohydrateBars = {
                    plateDetailViewModel.getCarbohydrateBars()
                },
                getSugarBars = {
                    plateDetailViewModel.getSugarBars()
                },
                getFatBars = {
                    plateDetailViewModel.getFatBars()
                }
            )
        }

        composable(AppRoutes.HOME) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val state = homeViewModel.state.collectAsState()
            HomeScreen(
                state = state.value,
                onClickSearch = {
                    navController.navigate(AppRoutes.SEARCH)
                },
                onClickLogout = {
                    authViewModel.logout()
                },
                onClickDish = { dish ->
                    val jsonDish = Uri.encode(Gson().toJson(dish))
                    navController.navigate("${AppRoutes.PLATEDETAIL}/$jsonDish")
                }

            )
        }
        composable(AppRoutes.LOGIN) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            val state = loginViewModel.state.collectAsState()
            val listener = loginViewModel.listener.collectAsState()
            LoginScreen(
                state = state.value,
                listener = listener.value,
                onLogin = { email, password ->
                    loginViewModel.login(email, password, onEnd = {
                        authViewModel.checkUserLoggedIn()
                    })
                },
                onRegister = { name, email, password ->
                    loginViewModel.register(name, email, password)
                },
                onClickCreateAccount = {

                },
                onClickAlreadyHaveAccount = {},
                onChangeAuthMode = { isLogin ->
                    loginViewModel.changeAuthMode(isLogin)
                }
            )
        }
    }
}
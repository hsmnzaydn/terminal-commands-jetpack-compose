package com.hsmnzaydn.terminalcommandsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list.CategoryListScreen
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.command_list.CommandListScreen
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.search.SearchScreen
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.search.SearchViewModel
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.splash.SplashScreen
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.TerminalCommandsJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerminalCommandsJetpackComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash", builder = {
                    composable("splash") {
                        SplashScreen(
                            navController = navController,
                            splashViewModel = hiltViewModel()
                        )
                    }
                    composable("categorylist") {
                        CategoryListScreen(
                            navController = navController,
                            categoryListViewModel = hiltViewModel()
                        )
                    }
                    composable("commandlist/{categoryId}",arguments = listOf(
                        navArgument("categoryId"){
                            type = NavType.StringType
                        }
                    )) {
                        CommandListScreen(
                            navController = navController,
                            commandListViewModel = hiltViewModel(),
                            it.arguments?.getString("categoryId", "1")?:""
                        )
                    }
                    composable("search") {
                        SearchScreen(
                            navController = navController,
                            searchViewModel = hiltViewModel<SearchViewModel>()
                        )
                    }
                })

            }
        }
    }
}


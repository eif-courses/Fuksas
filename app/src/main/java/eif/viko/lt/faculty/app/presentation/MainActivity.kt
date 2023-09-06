package eif.viko.lt.faculty.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import eif.viko.lt.faculty.app.R
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.navigation.MyAppNavHost
import eif.viko.lt.faculty.app.presentation.ui.components.AppBar
import eif.viko.lt.faculty.app.presentation.ui.components.DrawerBody
import eif.viko.lt.faculty.app.presentation.ui.components.DrawerHeader
import eif.viko.lt.faculty.app.presentation.ui.components.MenuItem
import eif.viko.lt.faculty.app.presentation.ui.theme.FuksasTheme
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuksasTheme {
                val dummyList = listOf(
                    MenuItem(
                        Route.CATEGORIES_SCREEN,
                        "Categories",
                        "categories",
                        Icons.Default.Person
                    ),
                    MenuItem(
                        Route.PRODUCT_CATEGORIES_SCREEN,
                        "Products",
                        "products",
                        Icons.Default.ShoppingCart
                    ),
                    MenuItem(
                        Route.GROUP_SCREEN,
                        "Groups",
                        "groups",
                        Icons.Default.List
                    ),
                    MenuItem(
                        Route.AUTH_SCREEN,
                        "Auth",
                        "auth",
                        Icons.Default.ArrowForward
                    )
                )
                val navController = rememberNavController()
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet(
                            //drawerShape = ,
                            //drawerTonalElevation = …,
                            //drawerContainerColor = …,
                            //drawerContentColor = …,
                            content = {
                                DrawerHeader()
                                DrawerBody(items = dummyList, onItemClick = {
                                    navController.navigate(it.id)
                                    scope.launch {
                                        drawerState.close()
                                    }
                                })
                            },
                        )
                    },
                    gesturesEnabled = true,
                    //scrimColor = Color.Magenta
                    content = {
                        Scaffold(
                            topBar = {
                                AppBar(
                                    onNavigationIconClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }
                                )
                            },
                        ) {
                            MyAppNavHost(
                                Modifier.padding(it),
                                navController = navController,
                            )
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FuksasTheme {
        val dummyList = listOf(
            MenuItem(
                Route.CATEGORIES_SCREEN,
                "Categories",
                "categories",
                Icons.Default.Person
            ),
            MenuItem(
                Route.GROUP_SCREEN,
                "Groups",
                "groups",
                Icons.Default.List
            )
        )
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    //drawerShape = ,
                    //drawerTonalElevation = …,
                    //drawerContainerColor = …,
                    //drawerContentColor = …,
                    content = {
                        DrawerHeader()
                        DrawerBody(items = dummyList, onItemClick = {
                            navController.navigate(it.id)
                            scope.launch {
                                drawerState.close()
                            }
                        })
                    },
                )
            },
            gesturesEnabled = true,
            //scrimColor = Color.Magenta
            content = {
                Scaffold(
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        )
                    },
                ) {
                    MyAppNavHost(
                        Modifier.padding(it),
                        navController = navController,
                    )
                }
            }
        )
    }
}



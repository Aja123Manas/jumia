package com.example.jumia.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jumia.ui.theme.screens.account.AccountScreen
import com.example.jumia.ui.theme.screens.asked.AskedScreen
import com.example.jumia.ui.theme.screens.categories.CategoriesScreen
import com.example.jumia.ui.theme.screens.email.EmailScreen
import com.example.jumia.ui.theme.screens.feed.FeedScreen
import com.example.jumia.ui.theme.screens.follow.FollowScreen
import com.example.jumia.ui.theme.screens.four.FourScreen
import com.example.jumia.ui.theme.screens.help.HelpScreen
import com.example.jumia.ui.theme.screens.home.HomeScreen
import com.example.jumia.ui.theme.screens.login.LoginScreen
import com.example.jumia.ui.theme.screens.one.OneScreen
import com.example.jumia.ui.theme.screens.policy.PolicyScreen
import com.example.jumia.ui.theme.screens.products.AddProductsScreen
import com.example.jumia.ui.theme.screens.products.ViewProductsScreen
import com.example.jumia.ui.theme.screens.recentlys.RecentlysScreen
import com.example.jumia.ui.theme.screens.recentlyv.RecentlyvScreen
import com.example.jumia.ui.theme.screens.shopping.ShopScreen
import com.example.jumia.ui.theme.screens.signup.SignupScreen
import com.example.jumia.ui.theme.screens.splash.SplashScreen
import com.example.jumia.ui.theme.screens.three.ThreeScreen
import com.example.jumia.ui.theme.screens.two.TwoScreen
import com.example.jumia.ui.theme.screens.splash.SplashScreen

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(LOGIN_URL) {
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL) {
            SignupScreen(navController = navController)
        }

        composable(SHOP_URL) {
            ShopScreen(navController = navController)
        }

        composable(ACCOUNT_URL) {
            AccountScreen(navController = navController)
        }

        composable(HOME_URL) {
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL) {
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navController = navController)
        }

        composable(CATEGORIES_URL) {
            CategoriesScreen(navController = navController)
        }
        composable(EMAIL_URL) {
            EmailScreen(navController = navController)
        }


        composable(RECENTLYS_URL) {
            RecentlysScreen(navController = navController)
        }
        composable(RECENTLYV_URL) {
            RecentlyvScreen(navController = navController)
        }

        composable(FOUR_URL) {
            FourScreen(navController = navController)
        }

        composable(ONE_URL) {
            OneScreen(navController = navController)
        }
        composable(THREE_URL) {
            ThreeScreen(navController = navController)
        }

        composable(TWO_URL) {
            TwoScreen(navController = navController)
        }
        composable(SPLASH_URL) {
            SplashScreen(navController = navController)
        }


        composable(POLICY_URL) {
            PolicyScreen(navController = navController)
        }
        composable(ASKED_URL) {
            AskedScreen(navController = navController)
        }


        composable(FEED_URL) {
            FeedScreen(navController = navController)
        }

        composable(HELP_URL) {
            HelpScreen(navController = navController)
        }



        composable(FOLLOW_URL) {
            FollowScreen(navController = navController)
        }





    }
}
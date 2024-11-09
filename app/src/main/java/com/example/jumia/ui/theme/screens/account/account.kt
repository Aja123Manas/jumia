package com.example.jumia.ui.theme.screens.account

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jumia.R
import com.example.jumia.navigation.LOGIN_URL
import com.example.jumia.navigation.ONE_URL
import com.example.jumia.navigation.RECENTLYS_URL
import com.example.jumia.navigation.RECENTLYV_URL
import com.example.jumia.navigation.SHOP_URL
import com.example.jumia.navigation.TWO_URL
import com.example.jumia.ui.theme.JumiaTheme
import com.example.jumia.ui.theme.screens.home.BottomNavItem
import com.example.jumia.ui.theme.screens.home.bottomNavItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController:NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {

                                Icon(
                                    imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title
                                )


                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }

                Spacer(modifier = Modifier.height(0.dp))


            },
            content = @Composable {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .paint(
                            painterResource(id = R.drawable.black),
                            contentScale = ContentScale.FillBounds
                        ) ) {

                        Text(
                            text = "   Account",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Bold,
                        )




                        TopAppBar(
                            title = {
                            },
                            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
                            modifier = Modifier.padding(start = 200.dp),

                            navigationIcon = {
                                IconButton(onClick = {
                                }
                                )
                                {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Menu",

                                        tint = Color.White
                                    )
                                }

                            },

                            actions = {


                                IconButton(onClick = {
                                    navController.navigate(SHOP_URL)
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = "Share",
                                        tint = Color.White
                                    )
                                }
                            }
                        )
                    }

                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .paint(
                            painterResource(id = R.drawable.black),
                            contentScale = ContentScale.FillBounds
                        ) ) {
                        Column {


                            Text(
                                text = "   Welcome!",
                                fontFamily = FontFamily.Default,
                                fontSize = 18.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,

                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "   Enter Your account",
                                fontFamily = FontFamily.Default,
                                fontSize = 12.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,

                                fontWeight = FontWeight.Bold,
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(start = 10.dp)) {


                        Image(
                            painter = painterResource(id = R.drawable.see),
                            contentDescription = "hotel",
                            modifier = Modifier
                                .size(20.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "   Login to see your balance",
                            fontFamily = FontFamily.Default,
                            fontSize = 12.sp,
                            color = Color.Blue,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            text = "   MY JUMIA ACCOUNT",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Normal,
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                    ) {
                        Column(modifier = Modifier.padding(start = 15.dp)) {

                            Image(
                                painter = painterResource(id = R.drawable.inbox),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))


                            Image(
                                painter = painterResource(id = R.drawable.rr),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )


                            Spacer(modifier = Modifier.height(15.dp))


                            Image(
                                painter = painterResource(id = R.drawable.v),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(50.dp))




                        Column {


                            Text(
                                text = "Inbox",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )
                            Spacer(modifier = Modifier.height(15.dp))


                            Text(
                                text = "Rating Reviews",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )

                            Spacer(modifier = Modifier.height(15.dp))


                            Text(
                                text = "Vouchers",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )

                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(120.dp))


                        Column {
                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(LOGIN_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(LOGIN_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )



                            Spacer(modifier = Modifier.height(15.dp))

                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(ONE_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )



                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                    ) {
                        Column(modifier = Modifier.padding(start = 15.dp)) {

                            Image(
                                painter = painterResource(id = R.drawable.saved),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))


                            Image(
                                painter = painterResource(id = R.drawable.sign),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )


                            Spacer(modifier = Modifier.height(15.dp))


                            Image(
                                painter = painterResource(id = R.drawable.rv),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(50.dp))




                        Column {


                            Text(
                                text = "Saved Items",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )
                            Spacer(modifier = Modifier.height(15.dp))


                            Text(
                                text = "Follow Seller",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )

                            Spacer(modifier = Modifier.height(15.dp))


                            Text(
                                text = "Recently Viewed",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )

                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(120.dp))


                        Column {
                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(LOGIN_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(TWO_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )



                            Spacer(modifier = Modifier.height(15.dp))

                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {                     navController.navigate(
                                        RECENTLYV_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier=Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }




                                }



                            )



                        }
                    }



                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                    ) {
                        Column(modifier = Modifier.padding(start = 15.dp)) {

                            Image(
                                painter = painterResource(id = R.drawable.rs),
                                contentDescription = "Dubai",
                                modifier = Modifier
                                    .size(20.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))




                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(50.dp))




                        Column {


                            Text(
                                text = "Recently Searched",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 20.dp)

                            )
                            Spacer(modifier = Modifier.height(15.dp))



                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Spacer(modifier = Modifier.width(100.dp))


                        Column {
                            TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                title = {
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                                actions = {


                                    IconButton(onClick = {
                                        navController.navigate(RECENTLYS_URL)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            contentDescription = "Share",
                                            modifier = Modifier.size(30.dp),
                                            tint = Color.Black

                                        )
                                    }


                                }


                            )

                            Spacer(modifier = Modifier.height(15.dp))


                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Row {
                        Text(
                            text = "   MY SETTINGS",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Normal,
                        )

                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Row {
                        Text(
                            text = "   Address book",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Medium,
                        )


                        Spacer(modifier = Modifier.width(215.dp))

                        TopAppBar(modifier = Modifier.size(width = 20.dp, height = 20.dp),
                            title = {
                            },
                            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),


                            actions = {


                                IconButton(onClick = {
                                    navController.navigate(LOGIN_URL)
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = "Share",
                                        modifier = Modifier.size(30.dp),
                                        tint = Color.Black

                                    )
                                }


                            }


                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                            navController.navigate(LOGIN_URL)


                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.LightGray),
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(height = 150.dp, width = 0.dp)
                    ) {
                        Text(text = "LOGIN",
                            color = Color.Yellow)
                    }

                    Spacer(modifier = Modifier.height(100.dp))


                }

























            }
        )















    }

}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = true,
        badges=0
    ),



    BottomNavItem(
        title = "Category",
        route="categories",
        selectedIcon=Icons.Filled.List,
        unselectedIcon=Icons.Outlined.List,
        hasNews = true,
        badges=5
    ),


    BottomNavItem(
        title = "Feed",
        route="feed",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Star,
        hasNews = true,
        badges=5
    ),




    BottomNavItem(
        title = "Account",
        route="account",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=1
    ),


    BottomNavItem(
        title = "Help",
        route="help",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=1
    ),


    )






data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun AccountScreenPreview(){
    JumiaTheme {
        AccountScreen(navController = rememberNavController())
    }
}

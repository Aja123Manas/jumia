package com.example.jumia.ui.theme.screens.feed

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
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
import com.example.jumia.navigation.FEED_URL
import com.example.jumia.navigation.FOLLOW_URL
import com.example.jumia.navigation.SHOP_URL
import com.example.jumia.ui.theme.JumiaTheme
import com.example.jumia.ui.theme.screens.home.BottomNavItem
import com.example.jumia.ui.theme.screens.home.bottomNavItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(navController:NavHostController) {

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

                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start


                ) {


                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .paint(
                            painterResource(id = R.drawable.black),
                            contentScale = ContentScale.FillBounds
                        ) ) {
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "   Feed",
                            fontFamily = FontFamily.Default,
                            fontSize = 30.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,

                            fontWeight = FontWeight.Bold,
                        )


                        Spacer(modifier = Modifier.width(60.dp))


                        TopAppBar(
                            title = {
                            },
                            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
                            modifier = Modifier.padding(start = 150.dp),

                            navigationIcon = {
                                IconButton(onClick = { navController.navigate(SHOP_URL)
                                }
                                )
                                {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = "Menu",

                                        tint = Color.White
                                    )
                                }

                            },


                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))






                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)

                            .paint(
                                painterResource(id = R.drawable.lb),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Column {
                            Text(
                                text = "FOLLOWING",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .clickable {
                                        navController.navigate(FOLLOW_URL)
                                    }
                            )
                        }


                        Spacer(modifier = Modifier.width(30.dp))

                        Column {
                            Text(
                                text = "EXPLORE",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .clickable {
                                        navController.navigate(FEED_URL)
                                    }
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.garnier),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.earn),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.nia),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.White)
                        )
                        {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.st),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.waist),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.sd),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.wrist),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bd),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.th),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.box),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.calc),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.color),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))




                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.pillow),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.e),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.iphone),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.pi),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.socks),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.gi),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))




                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.lo),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.tr),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.tiss),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bana),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vegies),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.soko),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.nestle),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.zina),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.coffee),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.flowers),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.paint),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vase),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.com),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.r),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.carpets),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.hair),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.geisha),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.furniture),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.machine),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.highlighter),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.doll),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.blender),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.gr),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.mop),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vacuum),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.box),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bag),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.oil),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.au),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "Deals of the Day")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check our Deals of the Day",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ap),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.fridge),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.y),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,

                            )
                        Spacer(modifier = Modifier.width(50.dp))
                        OutlinedButton(
                            onClick = {

                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("ajamanas@gmail.com")
                                )


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(1.dp, color = Color.Magenta)
                        ) {

                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Menu",
                                tint = Color.Magenta,
                            )
                            Spacer(modifier = Modifier.width(4.dp))


                            Text(text = "SHARE", color = Color.Magenta)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 200.dp)
                    ) {
                        Text(text = "New Products")
                    }
                    Spacer(modifier = Modifier.height(1.dp))


                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()

                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon),
                                contentDescription = "hotel",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape),
                                contentScale = ContentScale.Crop


                            )


                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Check the Newst Products!",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))


                    Row {

                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.massage),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ball),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.winter),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp)
                    ) {
                        Text(
                            text = "14 hours Ago",
                            fontFamily = FontFamily.Default,
                            fontSize = 18.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                        )
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
fun FeedScreenPreview(){
    JumiaTheme {
        FeedScreen(navController = rememberNavController())
    }
}

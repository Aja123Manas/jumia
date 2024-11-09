package com.example.jumia.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.jumia.ui.theme.JumiaTheme
import com.example.jumia.R
import com.example.jumia.navigation.HOME_URL
import com.example.jumia.navigation.SHOP_URL

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){

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


            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {

                    Spacer(modifier = Modifier.height(15.dp))

                    Row {
                        var search by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = search,
                            onValueChange = { search = it },
                            placeholder = { Text(text = "Search on Jumia") },
                            leadingIcon = {
                                Image(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = ""
                                )
                            },
                            modifier = Modifier
                                .padding(start = 5.dp, end = 20.dp)

                        )

                        Spacer(modifier = Modifier.width(2.dp))


                        TopAppBar(
                            title = {

                            },
                            navigationIcon = {
                                IconButton(onClick = { navController.navigate(SHOP_URL)
                                }
                                )
                                {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = "ShoppingCart",
                                        tint = Color.Black
                                    )
                                }

                            },

                            )


                    }
                    Spacer(modifier = Modifier.height(15.dp))




                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())

                            .padding(start = 10.dp)
                    ) {
                        //Row one
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.j1),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                        }
                        //End of Row one
                        Spacer(modifier = Modifier.width(5.dp))
                        //Row two
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.j),
                                    "Mt.Kenya",
                                    Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        //End Row two

                        Spacer(modifier = Modifier.width(5.dp))

                        //Row one
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.d23),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                        }
                        //End of Row one
                        Spacer(modifier = Modifier.width(5.dp))
                        //Row two
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.d20),
                                    "Mt.Kenya",
                                    Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        //End Row two
                        Spacer(modifier = Modifier.width(5.dp))

                        //Row one
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.d22),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                        }
                        //End of Row one
                        Spacer(modifier = Modifier.width(5.dp))
                        //Row two
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.d25),
                                    "Mt.Kenya",
                                    Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        //End Row two

                        Spacer(modifier = Modifier.width(5.dp))


                        //Row one
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.j2),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                        }
                        //End of Row one
                        Spacer(modifier = Modifier.width(5.dp))
                        //Row two
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(200.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.j3),
                                    "Mt.Kenya",
                                    Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        //End Row two
                    }


                    Spacer(modifier = Modifier.height(15.dp))



                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(180.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {


                        Spacer(modifier = Modifier.height(15.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp)
                        )
                        {


                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.pp),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    Phones & ",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,

                                    fontWeight = FontWeight.Normal,
                                )


                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    Accessories",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,

                                    color = Color.White,
                                    fontWeight = FontWeight.Normal,
                                )





                                Spacer(modifier = Modifier.height(2.dp))
                            }

                            //End of column
                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.c),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "   Clearance Sale",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.s),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "  Special Offers",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(130.dp)

                            .paint(
                                painterResource(id = R.drawable.w),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {


                        Row(
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {


                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.fl),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    Flash Sale",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,

                                    fontWeight = FontWeight.Normal,
                                )


                            }

                            //End of column
                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ph),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "        Phones",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.t),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "           TVs",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }


                            Spacer(modifier = Modifier.width(10.dp))


//Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ju),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Earn Money",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,

                                    fontWeight = FontWeight.Normal,
                                )


                            }

                            //End of column
                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ap),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = " Appliances",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.au),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Home Audio",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))


//Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.f),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "   Fashion ",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,

                                    fontWeight = FontWeight.Normal,
                                )


                            }

                            //End of column
                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.tele),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Call To Order",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.com),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = " Computing",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }
                            Spacer(modifier = Modifier.width(10.dp))

//Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.dec),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "       Home ",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,

                                    fontWeight = FontWeight.Normal,
                                )


                            }

                            //End of column
                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bea),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "      Beauty",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }



                            Spacer(modifier = Modifier.width(10.dp))
                            //Column one
                            Column {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.gr),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    Grocery",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }


                        }
                    }

                    TopAppBar(
                        title = {
                            Text(
                                text = "Flash Sales" +
                                        "             TIME LEFT:1WEEK",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Red),

                        navigationIcon = {
                            IconButton(onClick = {
                            }
                            )
                            {

                            }

                        },


                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))



    Row(
        modifier = Modifier

            .horizontalScroll(rememberScrollState())
            .padding(start = 15.dp)
    ) {
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
                        painter = painterResource(id = R.drawable.g),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Anti-Blemish Charco..",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 1,295",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "690 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {}


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.y),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Fashion Sexy Yoga p..",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 712",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "30 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))


//Column one
        Column {
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.o),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "RF/335 - 85L single...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 16,999",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "569 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.cat),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Art Mural Cat Print T...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 376",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "86 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "3-Piece Set of Busin...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )
            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 1,350",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "1 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.blend),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "RN-999 2 In 1 Blend...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 1,80",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "468 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.sp),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "V4000 2.1Ch Bluetoo...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 2,799",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "74 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.tv),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "HTC3200S, 32 Smar...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 11,799",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "302 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.spp),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "AM-02 2.1CH Multi...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 5,450",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "6 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))

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
                        painter = painterResource(id = R.drawable.speaker),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "V643 3.1Ch Bluet...",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "Ksh 4,599",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "271 items left",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Button(
                onClick = {
                    navController.navigate(HOME_URL)


                },
                shape = RoundedCornerShape(1000.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {

            }


        }


        //End of column
        Spacer(modifier = Modifier.width(10.dp))


    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp)

            .paint(
                painterResource(id = R.drawable.black),
                contentScale = ContentScale.FillBounds
            )
    ) {}


    Spacer(modifier = Modifier.height(2.dp))
    Text(
        text = "Sponsored Products",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )



    Spacer(modifier = Modifier.height(2.dp))





    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(start = 15.dp)
    ) {
        Spacer(modifier = Modifier.height(2.dp))


        //Column one
        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lp),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "HP EliteBook 840 G..",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 39,199",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(2.dp))



        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.jer),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "Jersey 24/25 Chels",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 1,899",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(2.dp))




        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.niv),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "Nivea Pearl & Beauty ..",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 690",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(2.dp))




        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cas),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "Herbella Organic Ca..",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 1,150",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(2.dp))




        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pop),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "Folding Pop Socket..",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 150",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(2.dp))




        Column {
            Card(
                modifier = Modifier
                    .width(130.dp)
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wash),
                        contentDescription = "Dubai",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "Sktworth F80215M..",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Thin,
            )

            Spacer(modifier = Modifier.height(1.dp))


            Text(
                text = "Ksh 42,999",
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.width(2.dp))

        }
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
fun HomeScreenPreview(){
    JumiaTheme {
        HomeScreen(navController = rememberNavController())
    }
}
package com.example.jumia.ui.theme.screens.categories

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
import com.example.jumia.navigation.SHOP_URL

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController:NavHostController){

    Column(
        modifier = Modifier.fillMaxWidth(),
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

                                Icon(imageVector =
                                if (index == selected)
                                    bottomNavItem.selectedIcon
                                else
                                    bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title)


                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            //Content Section
            content = @Composable{
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
                                IconButton(onClick = {navController.navigate(SHOP_URL)
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

                    TopAppBar(
                        title = {
                            Text(
                                text = "ADD THREE TO CART || GET 33% OFF",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.paty),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxWidth(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    Cargo Pants",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.oven),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "    0ven    ",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.r),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Royco Powder",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.d),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = " Dresses",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.shoe),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Shoes",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.fridge),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Fridge",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.r),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "Royco Powder",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.n),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxWidth(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "   Nivea Lotion",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.toys),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = " Toys",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.suit),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "  Suits    ",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.perf),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "  Perfumes",
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
                                        .width(80.dp)
                                        .height(80.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.plates),
                                        contentDescription = "Mt.Kenya",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.None
                                    )


                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "  Plates",
                                    fontFamily = FontFamily.Default,
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(2.dp))
                            }


                        }
                    }


                    Spacer(modifier = Modifier.height(8.dp))

                    TopAppBar(
                        title = {
                            Text(
                                text = "ADD THREE TO CART || GET 33% OFF   SEE ALL ORDERS",
                                color = Color.Black,
                                fontSize = 15.sp

                            )

                        },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.LightGray),

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
                                        painter = painterResource(id = R.drawable.rice),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Rice Cooker",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 9000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.furniture),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Furniture",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 15000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.blender),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Blender",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.scarfs),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Scarfs",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.detergents),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Detergents",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 8000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.vacuum),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Vacuum Cleaner",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 20,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.viatu),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Nike Shoes",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 5000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.gg),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Cooking Spices",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 10,500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.bracelets),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Bracelets",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.shirts),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Men Shirts",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 2500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(40.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Raise The Bar | Top Deals ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 40.dp, start = 40.dp)
                    ) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.vens),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.machine),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }

                        //End of column


                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one


                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.appl),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 40.dp, start = 40.dp)
                    ) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.dec1),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.stand),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }

                        //End of column


                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one


                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hs),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }
                    }




                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 40.dp, start = 40.dp)
                    ) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.wear),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.nova),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }

                        //End of column


                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one


                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.woman),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 40.dp, start = 40.dp)
                    ) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.products),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.skin),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }

                        //End of column


                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one


                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.up),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }
                    }



                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 40.dp, start = 40.dp)
                    ) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.make),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.nice),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }

                        //End of column


                        Spacer(modifier = Modifier.width(10.dp))


                        //Column one


                        Column {
                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(160.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hair),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(40.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Raise The Bar | On Appliances ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

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
                                        painter = painterResource(id = R.drawable.pc),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Plate Cooker",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.mika),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Mika Cooker",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 3500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.fridge),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Ramtonz Fridge",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 20,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(5.dp))

                    }

                    Spacer(modifier = Modifier.height(10.dp))


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
                                        painter = painterResource(id = R.drawable.air),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Air Cooker",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 5500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.mix),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Fruit Mixer",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 7000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.tub),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Dish Washer",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 7500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))

                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(40.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Raise The Bar | Home Essentials ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

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
                                        painter = painterResource(id = R.drawable.curtains),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Curtains",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 20,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.pillow),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Pillows",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 700",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.beddings),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Beddings",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(5.dp))

                    }

                    Spacer(modifier = Modifier.height(10.dp))


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
                                        painter = painterResource(id = R.drawable.carpets),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = " Carpets",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 16,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.wall),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Wall Decors",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 50,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.mop),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "House Mopper",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))

                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(40.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Raise The Bar | On Fashion ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

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
                                        painter = painterResource(id = R.drawable.ties),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Ties for Men",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.h),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Heels",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 4000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.doll),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Doll Shoes",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 3500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(5.dp))

                    }

                    Spacer(modifier = Modifier.height(10.dp))


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
                                        painter = painterResource(id = R.drawable.men),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Suit",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 25,000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.ress),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Women Dresses",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1500",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.glasses),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Sunglasses",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 800",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))

                    }

                    Spacer(modifier = Modifier.height(20.dp))




                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(40.dp)

                            .paint(
                                painterResource(id = R.drawable.black),
                                contentScale = ContentScale.FillBounds
                            )
                    ) {
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Raise The Bar | On Beauty ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

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
                                        painter = painterResource(id = R.drawable.eye),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Eye Shadow",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.brushes),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Brushes",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 800",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.lipstick),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Lipsticks",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(5.dp))

                    }

                    Spacer(modifier = Modifier.height(10.dp))


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
                                        painter = painterResource(id = R.drawable.lashes),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Eye Lashes",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1000",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.foundation),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Foundation",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 1200",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


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
                                        painter = painterResource(id = R.drawable.oil),
                                        contentDescription = "Dubai",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Hair Oil",
                                fontFamily = FontFamily.Default,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Ksh 778",
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))


                        }

                        //End of column
                        Spacer(modifier = Modifier.width(10.dp))

                    }


                    Spacer(modifier = Modifier.height(20.dp))


                    Text(
                        text = "Recently Viewed",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )



                    Spacer(modifier = Modifier.height(10.dp))


                    Row(modifier = Modifier.padding(start = 25.dp)) {
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(160.dp)
                                    .height(100.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.products),
                                    contentDescription = "Dubai",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "Beauty Products",
                                fontFamily = FontFamily.Cursive,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                            )

                            Spacer(modifier = Modifier.height(2.dp))
                        }

                        //End of column
                        Spacer(modifier = Modifier.width(5.dp))
                        //Column one
                        Column {
                            Card(
                                modifier = Modifier
                                    .width(160.dp)
                                    .height(100.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ap),
                                    contentDescription = "Mt.Kenya",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )


                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "      Appliances",
                                fontFamily = FontFamily.Cursive,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                            )

                            Spacer(modifier = Modifier.height(2.dp))
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
        hasNews = false,
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
fun CategoriesScreenPreview(){
    JumiaTheme {
        CategoriesScreen(navController = rememberNavController())
    }
}
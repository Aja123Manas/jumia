package com.example.jumia.ui.theme.screens.recentlys

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import com.example.jumia.ui.theme.JumiaTheme


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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
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
import com.example.jumia.navigation.ACCOUNT_URL
import com.example.jumia.navigation.CATEGORIES_URL
import com.example.jumia.navigation.HOME_URL
import com.example.jumia.navigation.LOGIN_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentlysScreen(navController:NavHostController){

    Row( modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .paint(
            painterResource(id = R.drawable.black),
            contentScale = ContentScale.FillBounds
        ) ) {


        TopAppBar(
            title = {
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
            modifier = Modifier.padding(start = 10.dp),

            navigationIcon = {
                IconButton(onClick = { navController.navigate(ACCOUNT_URL)
                }
                )
                {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Menu",

                        tint = Color.White
                    )
                }

            },

            )

        Spacer(modifier = Modifier.width(10.dp))




        Text(
            text = "   Feed",
            fontFamily = FontFamily.Default,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,

            fontWeight = FontWeight.Bold,
        )
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Column {
            Image(
                painter = painterResource(id = R.drawable.rs),
                contentDescription = "hotel",
                modifier = Modifier
                    .size(130.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop


            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp),

            horizontalAlignment = Alignment.Start
        ) {


            Text(
                text = "                No Recent Searches",
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Black,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "     You don't have yet any recent searches.",
                fontFamily = FontFamily.Default,
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Normal,
            )

        }
        Spacer(modifier = Modifier.height(30.dp))


        Button(
            onClick = {
                navController.navigate(CATEGORIES_URL)


            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Continue Shopping",
                color = Color.Black )
        }


        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Recommended For you",
            fontSize = 18.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 5.dp)
        )



        Spacer(modifier = Modifier.height(2.dp))





        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))


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
                            painter = painterResource(id = R.drawable.watch),
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
                            painter = painterResource(id = R.drawable.lp),
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
                            painter = painterResource(id = R.drawable.furniture),
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
                            painter = painterResource(id = R.drawable.hair),
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

@Composable
@Preview(showBackground = true)
fun RecentlysPreview(){
    JumiaTheme {


        RecentlysScreen(navController = rememberNavController())
    }
}


package com.example.jumia.ui.theme.screens.follow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.example.jumia.navigation.FEED_URL
import com.example.jumia.navigation.FOLLOW_URL
import com.example.jumia.navigation.LOGIN_URL

@Composable
fun FollowScreen(navController:NavHostController){


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)

            .paint(
                painterResource(id = R.drawable.background),
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



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Column {
            Image(
                painter = painterResource(id = R.drawable.sign),
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
                text = "Please sign in to access updates from your favorite sellers",
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Black,
            )

        }



        Spacer(modifier = Modifier.height(40.dp))


            Text(
                text = "You will receive daily notifications about the sellers that you follow and our most popular sellers",
                fontFamily = FontFamily.Default,
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Normal,
            )




        Spacer(modifier = Modifier.height(40.dp))



        Button(
            onClick = {
                navController.navigate(LOGIN_URL)


            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Sign In",
           color = Color.Black )
        }




    }
}

@Composable
@Preview(showBackground = true)
fun FollowPreview(){
    JumiaTheme {


        FollowScreen(navController = rememberNavController())
    }
}

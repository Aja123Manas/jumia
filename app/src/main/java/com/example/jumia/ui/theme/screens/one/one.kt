package com.example.jumia.ui.theme.screens.one


import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.jumia.navigation.HOME_URL
import com.example.jumia.navigation.LOGIN_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneScreen(navController:NavHostController){

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
                painter = painterResource(id = R.drawable.contact),
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
                text = "Please sign in to access this content",
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Black,
            )

        }



        Spacer(modifier = Modifier.height(40.dp))


        Text(
            text = "If you are not registered just sign in with your email or Facebook account",
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
fun OnePreview(){
    JumiaTheme {


        OneScreen(navController = rememberNavController())
    }
}

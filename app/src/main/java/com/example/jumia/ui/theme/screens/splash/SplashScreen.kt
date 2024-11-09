package com.example.jumia.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jumia.R
import com.example.jumia.navigation.HOME_URL
import com.example.jumia.ui.theme.JumiaTheme

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController:NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()

            .paint(
                painterResource(id = R.drawable.ppo),
                contentScale = ContentScale.FillBounds
            )
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 0.dp)

        ) {


            //Lottie Animation

            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.sales))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(
                composition, progress,
                modifier = Modifier.size(400.dp)

            )

    Text(
        text = "            JUMIA",
        fontFamily = FontFamily.Default,
        fontSize = 40.sp,
        color = Color.White,
        textAlign = TextAlign.Center,

        fontWeight = FontWeight.ExtraBold,
    )



            //End of lottie animation

            val coroutine = rememberCoroutineScope()

            coroutine.launch {
                delay(2000)
                navController.navigate(HOME_URL)
            }


        }

    }

}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    JumiaTheme {
        SplashScreen(navController = rememberNavController())
    }
}
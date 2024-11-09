package com.example.jumia.ui.theme.screens.four



import androidx.compose.foundation.Image
import com.example.jumia.ui.theme.JumiaTheme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@Composable
fun FourScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Column {
            Image(
                painter = painterResource(id = R.drawable.ju),
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
                text = "Phones & ",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.SemiBold,
            )

        }












    }
}

@Composable
@Preview(showBackground = true)
fun FourPreview(){
    JumiaTheme {


        FourScreen(navController = rememberNavController())
    }
}

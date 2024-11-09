package com.example.jumia.ui.theme.screens.email

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jumia.R
import com.example.jumia.navigation.FEED_URL

class IntentActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailScreen(navController = rememberNavController())

        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IntentActivity> {
        override fun createFromParcel(parcel: Parcel): IntentActivity {
            return IntentActivity(parcel)
        }

        override fun newArray(size: Int): Array<IntentActivity?> {
            return arrayOfNulls(size)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailScreen(navController: NavHostController) {


    Column (

        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            ))

    {
        val mContext = LocalContext.current

        //TopAppBar
        TopAppBar(
            title = {
                Text(
                    text = "CONTACT US",
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Magenta),

            navigationIcon = {
                IconButton(onClick = {  navController.navigate(FEED_URL)
                }
                )
                {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Menu",
                        tint = Color.Black
                    )
                }

            },


            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "favorite",
                        tint = Color.White
                    )
                }
            }
        )

        //End of TopAppBar

        Spacer(modifier = Modifier.height(50.dp))


        OutlinedButton(
            onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0720245837".toUri()
                smsIntent.putExtra("sms_body","I would love to bid for a house")
                mContext.startActivity(smsIntent)


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, color = Color.Magenta)
        ) {
            Text(text ="SMS", color = Color.Black )

        }
        Spacer(modifier = Modifier.height(80.dp))


        OutlinedButton(
            onClick = {

                val callIntent=Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0720245837".toUri()
                mContext.startActivity(callIntent)

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, color = Color.Magenta)
        ) {
            Text(text ="CALL", color = Color.Black )

        }
        Spacer(modifier = Modifier.height(80.dp))


        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ajamanas@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hi I would love to bid")


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, color = Color.Magenta)
        ) {
            Text(text ="EMAIL", color = Color.Black )

        }
        Spacer(modifier = Modifier.height(80.dp))



        Spacer(modifier = Modifier.height(5.dp))






    }
}
@Preview(showBackground = true)
@Composable
fun EmailPreview(){
    EmailScreen(navController = rememberNavController())
}

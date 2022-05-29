package com.android.mantrana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.mantrana.ui.theme.MantranaTheme

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MantranaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    SplashScreenPreview()
                }
            }
        }
    }
}
@Composable
fun SplashScreenPreview(

) {
    Box(){
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.background),

            contentDescription = "splashscreen Image",
            contentScale = ContentScale.Crop
        )

        Image(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            painter = painterResource(id = R.drawable.logo_big),
            alignment = Alignment.Center,
            contentDescription = "splashscreen Image",
            contentScale = ContentScale.Fit
        )


    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    MantranaTheme {
//       SplashScreenPreview()
//    }
//
//}
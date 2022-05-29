package com.android.mantrana

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mantrana.ui.theme.MantranaTheme

class WelcomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),

                ) {
                WelcomScreenPreview(modifier = Modifier.fillMaxSize(), "WELCOME",
                    "Do meditation. Stay focused.\nLive a healty life.")
            }
        }
    }
}


@Composable
fun WelcomScreenPreview(
    modifier: Modifier = Modifier.fillMaxSize(),
    heading: String ="",
    paragraph: String = ""
) {

    Box(modifier = Modifier.fillMaxSize()){

        Image(
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.background),
            contentDescription = "splashscreen Image",
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_big),
                contentDescription = "splashscreen Image",
                contentScale = ContentScale.Fit
            )


            Text(heading,
                textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
                color = Color.White
                )
            Spacer(modifier = Modifier.height(20.dp))

            Text(paragraph,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = { println("button works!") },
                contentPadding = PaddingValues(16.dp)){
                Text(text = "Login With Email ",
                    style = MaterialTheme.typography.body1,
                    color = Color.White)
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "Dont have an account ? Sign Up", style = MaterialTheme.typography.body1,
                color = Color.White)

        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            onClick = {

            }
        ) {
            Text("+")
        }


    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MantranaTheme {
        WelcomScreenPreview()
    }
}
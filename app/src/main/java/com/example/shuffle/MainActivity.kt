package com.example.shuffle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.shuffle.ui.theme.ShuffleTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShuffleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CardWithShuffleButton()
                }
            }
        }
    }
}




@Composable
fun CardWithShuffleButton() {
    var idx by remember { mutableStateOf( 0) }
    val cardList = listOf<Int>(
        R.drawable.card10,
        R.drawable.card5,
        R.drawable.card6,
        R.drawable.card7,
        R.drawable.card9
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = cardList[idx]),
            contentDescription = "card images"
        )
        Button(onClick = { idx = cardList.indices.random() }) {
            Text(
                text = "Shuffle",
                fontWeight = FontWeight.Bold
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShuffleTheme {
        CardWithShuffleButton()
    }
}
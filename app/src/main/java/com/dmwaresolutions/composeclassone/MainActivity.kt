package com.dmwaresolutions.composeclassone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmwaresolutions.composeclassone.ui.theme.ComposeClassOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.ceocard)
            val description = "Amazon guy with a little bit of WW style"
            val title = "Heisenberg, WW or The Amazon Guy?"
            Box(
                modifier = Modifier.fillMaxWidth(0.5f).padding(16.dp)
            ){
                MyImageCard(painter = painter, contentDescription = description, title = title )
            }
        }
    }
}

@Composable
fun MyImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Box(
            modifier = Modifier.height(200.dp),
            //contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter= painter,
                contentDescription= contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.align(Alignment.TopCenter).fillMaxSize()
            )
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent,Color.Black),
                        startY = 100f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyImageCardPreview() {
    ComposeClassOneTheme {

    }
}
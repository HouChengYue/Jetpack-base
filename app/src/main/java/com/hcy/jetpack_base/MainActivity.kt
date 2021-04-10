package com.hcy.jetpack_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hcy.compose.NetImageView
import com.hcy.jetpack_base.ui.theme.JetpackbaseTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            JetpackbaseTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//
//                }
//            }
            Column(
                modifier = Modifier
                    .background(Color(0x1A000000))
                    .fillMaxSize()
            ) {
                Greeting("Android")


                GlideImage(
                    data = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png",
                    modifier = Modifier
                        .background(Color(0xffffffff))
                        .padding(2.dp)
                        .width(125.dp)
                        .height(125.dp)
                        .clip(RoundedCornerShape(2.dp)),


                    ) {
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackbaseTheme {
        Column {
            Greeting("Android")
            NetImageView(imageUrl = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png",
                modifier = Modifier.height(125.dp).width(125.dp))
        }
    }
}
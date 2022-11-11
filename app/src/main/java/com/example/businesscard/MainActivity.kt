package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    InitContainer()
                }
            }
        }
    }
}

@Composable
fun BackgroundContainer() {
    FirstContainer()
    SecondContainer()
}

@Composable
fun FirstContainer() {
    val boxModifier = Modifier.fillMaxWidth()


    Column(
        modifier = boxModifier, horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FirstContainerLogoComposable()
        FirstContainerMyNameComposable()
        FirstContainerJobComposable()
    }
}

@Composable
fun SecondContainer() {
    val secondContainerModifier =
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)

    Column(modifier = secondContainerModifier) {
        SecondContainerRowContainer(Icons.Rounded.Call, "010-1234-5678")
        SecondContainerRowContainer(Icons.Rounded.Share, "JongChan")
        SecondContainerRowContainer(Icons.Rounded.Email, "dev.jchan91@gmail.com")
    }
}

@Composable
fun FirstContainerLogoComposable() {
    val img = painterResource(R.drawable.android_logo)
    val imgModifier = Modifier.size(100.dp)

    Image(painter = img, modifier = imgModifier, contentDescription = "logo")
}

@Composable
fun FirstContainerMyNameComposable() {
    Text(
        text = "JongChan Park",
        color = Color.White,
        fontSize = 38.sp,
        fontWeight = FontWeight.Thin
    )
}

@Composable
fun FirstContainerJobComposable() {
    Text(
        text = "Frontend Developer",
        color = colorResource(id = R.color.android_main_color),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SecondContainerRowContainer(target: ImageVector, contents: String) {
    val rowModifier =
        Modifier
            .padding(vertical = 5.dp)
//            .fillMaxWidth()
//            .border(width = 0.3.dp, Color.White)

    Row(modifier = rowModifier) {
        IconComposable(target)
        ContentsComposable(contents)
    }
}

@Composable
fun IconComposable(target: ImageVector) {
    val iconModifier = Modifier.size(25.dp)

    Icon(
        target,
        contentDescription = "phone",
        modifier = iconModifier,
        tint = colorResource(id = R.color.android_main_color)
    )
}

@Composable
fun ContentsComposable(contents: String) {
    val contentsModifier = Modifier.padding(horizontal = 20.dp)

    Text(text = contents, modifier = contentsModifier, color = Color.White)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InitContainer() {
    val initContainerModifier = Modifier.background(colorResource(id = R.color.main_background))

    BusinessCardTheme {
        Box(modifier = initContainerModifier, contentAlignment = Alignment.Center) {
            FirstContainer()
        }
        Box(contentAlignment = Alignment.BottomCenter) {
            SecondContainer()
        }
    }
}
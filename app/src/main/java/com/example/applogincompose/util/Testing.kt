package com.example.applogincompose.util

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applogincompose.ui.theme.AppLoginComposeTheme

// File to Test/Remember Jetpack Compose Concepts:

@Composable
fun Testing(name: String){
    Text(
        text = "Hello $name!",
        fontSize = 32.sp,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Gray)
            .border(2.dp, color = Color.Black)
            .padding(10.dp)
            .fillMaxWidth(0.5f)
    )
}

@Preview(showBackground = true)
@Composable
fun TestingPreview(){
    AppLoginComposeTheme {
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Testing("UserName")
        }
    }
}
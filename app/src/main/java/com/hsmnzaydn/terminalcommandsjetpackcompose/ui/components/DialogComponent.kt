package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background
import kotlinx.coroutines.delay


@Composable
@Preview
fun showDialog(title:String? ="System commands",description:String?="sadsdsasad"){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

    }
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(

            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = title?:"",color = Color.Gray,fontWeight = FontWeight.Bold,fontSize = 20.sp)
            },
            text = {
                Column() {
                    Text(description?:"",color = Color.White)
                }
            },
            buttons = {

            },
            modifier = Modifier.height(200.dp).width(300.dp).scale(scale.value),
            backgroundColor = Background
        )
    }
}

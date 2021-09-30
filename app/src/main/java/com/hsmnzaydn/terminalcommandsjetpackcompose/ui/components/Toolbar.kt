package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components

import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hsmnzaydn.terminalcommandsjetpackcompose.R
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background
import kotlinx.coroutines.runBlocking

@Composable
fun AppBar(
    isShowSearchField: Boolean,
    query: (String) -> Unit,
    clickSearchIcon: () -> Unit
) {

    Column() {
        AppBarPreview(isShowSearchField)
        Divider(color = Color.White, thickness = 1.dp)

    }
}

@Preview
@Composable
fun AppBarPreview(isShowSearchField: Boolean? = true) {
    var text by remember { mutableStateOf("") }
    var tempIsShowSearchField = remember {
        mutableStateOf(isShowSearchField)
    }

    val focusRequester = remember { FocusRequester() }
    Box(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(top = 8.dp)

    ) {
        tempIsShowSearchField.component1()?.let {
            if (!it) {
                Text(
                    text = "Categories",
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 16.dp)
                        .align(Alignment.BottomStart),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(

                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = null,
                    Modifier
                        .padding(end = 16.dp, bottom = 16.dp)
                        .clickable(enabled = true, onClick = {
                            tempIsShowSearchField.value = true
                            // clickSearchIcon.invoke()
                        })
                        .align(Alignment.BottomEnd)
                )
            } else {
                TextField(
                    value = text, onValueChange = {
                        text = it
                        //query.invoke(it)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_search_24),
                            contentDescription = null,
                            tint = Color.White
                        )

                    },
                    label = {
                        Text(
                            text = "Search",
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 16.dp)
                        )
                    },
                    modifier = Modifier
                        .focusRequester(focusRequester)
                        .focusable()
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .align(Alignment.BottomStart)
                       ,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        backgroundColor = Color.Transparent,
                        disabledTextColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    enabled = true
                )
            }

        }

    }

}
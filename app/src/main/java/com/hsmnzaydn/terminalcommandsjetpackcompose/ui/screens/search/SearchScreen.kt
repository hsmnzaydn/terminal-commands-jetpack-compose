package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.AppBar
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(Background)
    ) {
        AppBar("",true, {

        }, {

        })

    }
}
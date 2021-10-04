package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command


@Composable
fun CommandLazyColumn(commandList:List<Command>){
    LazyColumn(
        Modifier.padding(top = 32.dp)
    ) {
            items(commandList) { item ->
                ListItemOfCommands(command = item)
            }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemOfCommands(command: Command) {
    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        showDialog(command.title,command.description)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(80.dp)
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        onClick = {

            showDialog.value = true
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxHeight(1f)

        ) {
            Text(
                text = command.title,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
            Text(
                text = command.description,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                maxLines = 2, overflow = TextOverflow.Ellipsis
            )
        }
    }
}

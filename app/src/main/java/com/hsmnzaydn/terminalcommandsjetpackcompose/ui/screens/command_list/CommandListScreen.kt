package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.command_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.AppBar
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.LoadingRecipeListShimmer
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background

@Composable
fun CommandListScreen(
    navController: NavController,
    commandListViewModel: CommandListViewModel,
    categoryId: String
) {
    commandListViewModel.fetchCommands(categoryId)
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(Background)
    ) {

        AppBar("Commands",false, {

        }, {

        })
        CommandListContent(commandListViewModel,{

        })

    }
}

@Composable
fun CommandListContent(viewModel: CommandListViewModel, clickListener:(categoryId:String) -> Unit) {
    with(viewModel.categoryList){
        when(this.value.status){
            CoreDataState.Status.LOADING ->{
                LoadingRecipeListShimmer(imageHeight = 80.dp)
            }
            CoreDataState.Status.SUCCESS ->{

                LazyColumn(
                    Modifier.padding(top = 32.dp)
                ) {
                    value.data?.let {
                        items(it) { item ->
                            ListItemOfCommands(command = item,clickListener)
                        }
                    }

                }
            }
        }
    }



}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemOfCommands(command: Command, clickListener:(categoryId:String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(80.dp)
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        onClick = {
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
        }
    }
}



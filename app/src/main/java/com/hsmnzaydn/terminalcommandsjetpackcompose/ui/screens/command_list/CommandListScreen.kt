package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.command_list

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.*
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list.CategoryListContent
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list.CategoryListViewModel
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background

@Composable
fun CommandListScreen(
    navController: NavController,
    commandListViewModel: CommandListViewModel,
    categoryId: String
) {
    val isFetchCommandList = remember {
        mutableStateOf(false)
    }

    commandListViewModel.fetchCommands(categoryId)
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(Background)
    ) {

        AppBar("commands", navController,false,true, {
            if(it.length == 0){
                isFetchCommandList.value = false
            }else{
                isFetchCommandList.value = true
                commandListViewModel.fetchSearchComamnds(it)
            }
        }, {

        })

        if(isFetchCommandList.value){
            SearchCommandListContent(viewModel = commandListViewModel)

        }else{
            CommandListContent(commandListViewModel)

        }


    }
}

@Composable
fun CommandListContent(viewModel: CommandListViewModel){
    with(viewModel.commandList) {
        when (this.value.status) {
            CoreDataState.Status.LOADING -> {
                LoadingRecipeListShimmer(imageHeight = 80.dp)
            }
            CoreDataState.Status.SUCCESS -> {
                this.value.data?.let {
                    CommandLazyColumn(commandList = it)
                }
            }
            else -> {
                Toast.makeText(LocalContext.current,value.message?:"", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SearchCommandListContent(
    viewModel: CommandListViewModel
) {
    with(viewModel.commandList) {
        when (this.value.status) {
            CoreDataState.Status.LOADING -> {
                LoadingRecipeListShimmer(imageHeight = 80.dp)
            }
            CoreDataState.Status.SUCCESS -> {
                this.value.data?.let {
                    CommandLazyColumn(commandList = it)
                }
            }
            else -> {
                Toast.makeText(LocalContext.current,value.message?:"",Toast.LENGTH_SHORT).show()
            }
        }
    }

}




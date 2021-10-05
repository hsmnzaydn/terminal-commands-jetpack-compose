package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list

import android.view.View
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
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.AppBar
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.CommandLazyColumn
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.LoadingRecipeListShimmer
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background

@Composable
fun CategoryListScreen(
    navController: NavController,
    categoryListViewModel: CategoryListViewModel
) {
    val isFetchCommandList = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(Background)
    ) {

        AppBar("Category",navController,false,false, {
            if(it.length == 0){
                isFetchCommandList.value = false
            }else{
                isFetchCommandList.value = true
                categoryListViewModel.fetchSearchComamnds(it)
            }
        }, {

        })

        if(isFetchCommandList.value){
            CommandListContent(viewModel = categoryListViewModel)
        }else{
            categoryListViewModel.categoryList.value.data?.let {
                if (it.size == 0){
                    categoryListViewModel.fetchCategoryList()
                }
            }?: kotlin.run {
                categoryListViewModel.fetchCategoryList()
            }
            CategoryListContent(categoryListViewModel,{categoryId,categoryName ->
                navController.navigate("commandlist/${categoryId}/${categoryName}")
            })
        }

    }
}

@Composable
fun CategoryListContent(viewModel: CategoryListViewModel,clickListener:(categoryId:String,categoryName:String) -> Unit) {
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
                            ListItemOfCategory(category = item,clickListener)
                        }
                    }

                }
            }
            else -> {
                Toast.makeText(LocalContext.current,value.message?:"",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun CommandListContent(viewModel: CategoryListViewModel){
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemOfCategory(category: Category,clickListener:(categoryId:String,categoryName:String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(80.dp)
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        onClick = {
            clickListener(category.categoryId,category.categoryName)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxHeight(1f)

        ) {
            Text(
                text = category.categoryName,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}



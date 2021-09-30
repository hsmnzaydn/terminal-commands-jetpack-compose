package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.AppBar
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.components.LoadingRecipeListShimmer
import com.hsmnzaydn.terminalcommandsjetpackcompose.ui.theme.Background

@Composable
fun CategoryListScreen(
    navController: NavController,
    categoryListViewModel: CategoryListViewModel
) {
    categoryListViewModel.fetchCategoryList()
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(Background)
    ) {

        AppBar("Category",false, {

        }, {

        })
        CategoryListContent(categoryListViewModel)

    }
}

@Composable
fun CategoryListContent(viewModel: CategoryListViewModel) {
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
                            ListItemOfCategory(category = item)
                        }
                    }

                }
            }
        }
    }



}

@Composable
fun ListItemOfCategory(category: Category) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(80.dp)
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black
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



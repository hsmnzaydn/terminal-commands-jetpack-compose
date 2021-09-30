package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.category_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.terminalcommandsjetpackcompose.data.CategoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(): ViewModel(){
    val categoryList: MutableState<List<CategoryResponse>> = mutableStateOf(listOf())

    fun fetchCategoryList(){
        viewModelScope.launch {
            delay(5000L)
            categoryList.value = listOf<CategoryResponse>(CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse(),CategoryResponse())

        }
    }
}
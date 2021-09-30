package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse

interface CategoriesRepository{
    suspend fun getCategories():CoreBaseResponse<List<CategoryResponse>>
    suspend fun getCommandsOfCategory(categoryId:String):CoreBaseResponse<List<CommandResponse>>
}
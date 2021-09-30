package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse

interface CategoriesRepository{
    suspend fun getCategories():CoreBaseResponse<List<CategoryResponse>>
}
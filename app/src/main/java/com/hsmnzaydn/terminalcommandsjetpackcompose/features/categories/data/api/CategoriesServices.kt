package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.api

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import retrofit2.http.GET


interface CategoriesServices {
    @GET("categories")
    suspend fun getCategories():CoreBaseResponse<List<CategoryResponse>>
}
package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.api

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface CategoriesServices {
    @GET("categories")
    suspend fun getCategories():CoreBaseResponse<List<CategoryResponse>>

    @GET("categories/{categoryId}/commands")
    suspend fun getCommandsOfCategory(@Path("categoryId") categoryId:String): CoreBaseResponse<List<CommandResponse>>
}
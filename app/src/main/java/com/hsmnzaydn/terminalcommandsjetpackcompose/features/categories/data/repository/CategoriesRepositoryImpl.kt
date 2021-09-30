package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseServicesImp
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.api.CategoriesServices
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import retrofit2.Retrofit
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.repository.CategoriesRepository

class CategoriesRepositoryImpl(private val retrofit: Retrofit) : CoreBaseServicesImp(),
    CategoriesRepository {
    fun getCategoriesServices(): CategoriesServices =
        retrofit.create(CategoriesServices::class.java)

    override suspend fun getCategories(): CoreBaseResponse<List<CategoryResponse>> {
        return getResponse(request = {
            getCategoriesServices().getCategories()
        })
    }

}
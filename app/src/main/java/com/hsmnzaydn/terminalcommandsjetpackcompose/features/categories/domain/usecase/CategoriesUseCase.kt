package com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.usecase

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.entities.User
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.repository.CategoriesRepository
import com.hsmnzaydn.terminalcommandsjetpackcompose.utils.Config
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import toCategory
import javax.inject.Inject

//TODO: TÜM FONKSİYONLARIN ÜSTÜNE YORUM SATIRI KOYMAYI UNUTMA !!!!
class CategoriesUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository){

    fun getCategories(): Flow<CoreDataState<List<Category>>> {
        return flow {
            var result =  categoriesRepository.getCategories()
            result.data?.let {
                emit(CoreDataState.success(it.map {
                    it.toCategory()
                },result.code))
            }?: kotlin.run {
                emit(CoreDataState.error<List<Category>>(result.code,result.error?:""))
            }
        }
    }

}
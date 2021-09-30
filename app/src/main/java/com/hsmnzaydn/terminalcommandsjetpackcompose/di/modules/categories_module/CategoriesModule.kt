package com.hsmnzaydn.terminalcommandsjetpackcompose.di.modules.categories_module

import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.repository.CategoriesRepositoryImpl
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.repository.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CategoriesModule{

@Provides
@Singleton
fun provideCategoriesRepository(retrofit: Retrofit): CategoriesRepository {
return CategoriesRepositoryImpl(retrofit)
}
}
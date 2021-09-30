package com.hsmnzaydn.terminalcommandsjetpackcompose.di.modules.accounts_module

import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.repository.AccountsRepositoryImpl
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.repository.AccountsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AccountsModule {

    @Provides
    @Singleton
    fun provideAccountsRepository(retrofit: Retrofit): AccountsRepository {
        return AccountsRepositoryImpl(retrofit)
    }
}
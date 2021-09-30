package com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseServicesImp
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.api.AccountsServices
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterResponse
import retrofit2.Retrofit
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.repository.AccountsRepository

class AccountsRepositoryImpl(private val retrofit:Retrofit):CoreBaseServicesImp(),
    AccountsRepository {
fun getAccountsServices(): AccountsServices = retrofit.create(AccountsServices::class.java)
    override suspend fun registerUser(registerRequest: RegisterRequest): CoreBaseResponse<RegisterResponse> {
        return  getResponse (request = {
            getAccountsServices().register(registerRequest)
        })
    }

}
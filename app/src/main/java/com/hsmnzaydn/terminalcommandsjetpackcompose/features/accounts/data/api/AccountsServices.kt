package com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.api

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AccountsServices {
    @POST("accounts")
    suspend fun register(@Body registerRequest: RegisterRequest):CoreBaseResponse<RegisterResponse>
}
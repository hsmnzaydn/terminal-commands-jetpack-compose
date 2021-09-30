package com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterResponse

interface AccountsRepository{

    suspend fun registerUser(registerRequest: RegisterRequest):CoreBaseResponse<RegisterResponse>
}
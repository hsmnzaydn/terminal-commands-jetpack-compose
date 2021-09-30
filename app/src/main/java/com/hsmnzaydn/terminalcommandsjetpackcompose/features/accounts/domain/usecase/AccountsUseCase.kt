package com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.usecase

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.entities.User
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.repository.AccountsRepository
import com.hsmnzaydn.terminalcommandsjetpackcompose.utils.Config
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import toUser
import javax.inject.Inject

//TODO: TÜM FONKSİYONLARIN ÜSTÜNE YORUM SATIRI KOYMAYI UNUTMA !!!!
class AccountsUseCase @Inject constructor(private val accountsRepository: AccountsRepository){

    fun registerUser(registerRequest: RegisterRequest):Flow<CoreDataState<User>>{
        return flow {
            var result =  accountsRepository.registerUser(registerRequest)
          result.data?.let {
              Config.authorazationKey = it.authozationKey
                emit(CoreDataState.success(it.toUser(),result.code))
            }?: kotlin.run {
                emit(CoreDataState.error<User>(result.code,result.error?:""))
            }
        }
    }
}
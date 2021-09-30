package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterRequest
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.entities.User
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.usecase.AccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val accountsUseCase: AccountsUseCase): ViewModel(){
    var user: MutableState<CoreDataState<User>> = mutableStateOf(CoreDataState.loading())

    init {
        registerUser()
    }

    private fun registerUser() {
        viewModelScope.launch {
            accountsUseCase.registerUser(RegisterRequest("a","a")).collect {
                user.value = it
            }
        }

    }
}
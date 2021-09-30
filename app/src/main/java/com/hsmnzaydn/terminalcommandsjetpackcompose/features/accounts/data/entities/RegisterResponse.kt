package com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities

data class RegisterResponse(
    val authozationKey: String,
    val isAllowNotification: Boolean,
    val userId: String
)
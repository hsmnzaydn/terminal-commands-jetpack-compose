package com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse

interface CommandsRepository{

    suspend fun getSearchCommands(query:String):CoreBaseResponse<List<CommandResponse>>
}
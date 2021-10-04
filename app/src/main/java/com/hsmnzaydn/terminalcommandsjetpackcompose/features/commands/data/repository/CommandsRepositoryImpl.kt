package com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.data.repository

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseServicesImp
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.data.api.CommandsServices
import retrofit2.Retrofit
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.repository.CommandsRepository

class CommandsRepositoryImpl(private val retrofit:Retrofit):CoreBaseServicesImp(),
    CommandsRepository {
fun getCommandsServices(): CommandsServices = retrofit.create(CommandsServices::class.java)

    override suspend fun getSearchCommands(query: String): CoreBaseResponse<List<CommandResponse>> {
       return getResponse (request = {getCommandsServices().getSearchCommands(query)})
    }

}
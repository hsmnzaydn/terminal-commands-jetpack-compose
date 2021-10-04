package com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.data.api

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreBaseResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface CommandsServices {

    @GET("commands")
    suspend fun getSearchCommands(@Query("commandTitle") query:String):CoreBaseResponse<List<CommandResponse>>

}
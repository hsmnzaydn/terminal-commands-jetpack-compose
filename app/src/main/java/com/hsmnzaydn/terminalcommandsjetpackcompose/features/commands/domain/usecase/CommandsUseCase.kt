package com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.usecase

import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.repository.CommandsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import toCommand
import javax.inject.Inject

//TODO: TÜM FONKSİYONLARIN ÜSTÜNE YORUM SATIRI KOYMAYI UNUTMA !!!!
class CommandsUseCase @Inject constructor(private val commandsRepository: CommandsRepository){

    fun getSearchCommands(query:String): Flow<CoreDataState<List<Command>>> {
        return flow {
            var result =  commandsRepository.getSearchCommands(query)
            result.data?.let {
                emit(CoreDataState.success(it.map {
                    it.toCommand()
                },result.code))
            }?: kotlin.run {
                emit(CoreDataState.error<List<Command>>(result.code,result.error?:""))
            }
        }
    }
}
package com.hsmnzaydn.terminalcommandsjetpackcompose.ui.screens.command_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsmnzaydn.terminalcommandsjetpackcompose.base.CoreDataState
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.usecase.CategoriesUseCase
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.usecase.CommandsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommandListViewModel @Inject constructor(
    private val categoryUseCase: CategoriesUseCase,
    private val commandsUseCase: CommandsUseCase
) : ViewModel() {


    val commandList: MutableState<CoreDataState<List<Command>>> =
        mutableStateOf(CoreDataState.loading())

    fun fetchCommands(categoryId: String) {
        viewModelScope.launch {
            categoryUseCase.getCommandsOfCategories(categoryId).collect {
                delay(1200)
                commandList.value = it
            }
        }
    }

    fun fetchSearchComamnds(query: String) {
        viewModelScope.launch {
            commandsUseCase.getSearchCommands(query).collect {
                delay(1200)

                commandList.value = it
            }
        }
    }
}
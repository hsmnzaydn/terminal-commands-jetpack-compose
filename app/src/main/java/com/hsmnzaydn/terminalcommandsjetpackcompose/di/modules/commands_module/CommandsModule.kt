package com.hsmnzaydn.terminalcommandsjetpackcompose.di.modules.commands_module

import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.data.repository.CommandsRepositoryImpl
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.commands.domain.repository.CommandsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CommandsModule{

@Provides
@Singleton
fun provideCommandsRepository(retrofit: Retrofit): CommandsRepository {
return CommandsRepositoryImpl(retrofit)
}
}
package ruben.hernandez.rentalcar.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import ruben.hernandez.rentalcar.Implementations.PiezaImplementation
import ruben.hernandez.rentalcar.Implementations.SettingsImplementation
import ruben.hernandez.rentalcar.clients.HttpClientFactory
import ruben.hernandez.rentalcar.repositories.PiezasRepository
import ruben.hernandez.rentalcar.repositories.SettingsRepository
import ruben.hernandez.rentalcar.viewModels.Parts.PiezasViewModel
import ruben.hernandez.rentalcar.viewModels.SettingsViewModel
import ruben.hernandez.rentalcar.viewModels.AccountViewModel
import kotlinx.coroutines.CoroutineDispatcher
import ruben.hernandez.rentalcar.implementations.AccountImplementation
import ruben.hernandez.rentalcar.repositories.AccountRepository

expect val platformModule: Module

expect fun provideDispatcher(): CoroutineDispatcher

val appModule = module {
    // Definiciones existentes
    single<PiezasRepository> { PiezaImplementation(get()) }
    single { HttpClientFactory.create(get()) }
    viewModelOf(::PiezasViewModel)

    // Nuevas definiciones para ajustes
    single { provideDispatcher() }
    single<SettingsRepository> { SettingsImplementation(get()) }
    viewModelOf(::SettingsViewModel)

    // Nuevas definiciones para Account
    single<AccountRepository> { AccountImplementation(get()) }
    viewModelOf(::AccountViewModel)
}


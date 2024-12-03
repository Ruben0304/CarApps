package ruben.hernandez.rentalcar.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import ruben.hernandez.rentalcar.Implementations.PiezaImplementation
import ruben.hernandez.rentalcar.Implementations.PiezaImplementationTest
import ruben.hernandez.rentalcar.clients.HttpClientFactory
import ruben.hernandez.rentalcar.repositories.PiezasRepository
import ruben.hernandez.rentalcar.viewModels.Parts.PiezasViewModel

expect val platformModule: Module

val appModule = module {
    // Define el repositorio como singleton
    single<PiezasRepository> { PiezaImplementation(get()) }
    single { HttpClientFactory.create(get()) }

    // Usa viewModelOf para el ViewModel
    viewModelOf(::PiezasViewModel)
}
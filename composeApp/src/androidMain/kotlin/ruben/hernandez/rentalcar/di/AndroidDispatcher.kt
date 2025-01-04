package ruben.hernandez.rentalcar.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO


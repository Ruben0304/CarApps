package ruben.hernandez.rentalcar

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ruben.hernandez.rentalcar.di.appModule
import ruben.hernandez.rentalcar.di.initKoin
import ruben.hernandez.rentalcar.di.platformModule

class CarApp : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CarApp)
            modules(appModule, platformModule)
        }
    }
}
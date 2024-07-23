package application

import android.app.Application
import module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FilmListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FilmListApplication)
            modules(networkModule)
        }
    }
}

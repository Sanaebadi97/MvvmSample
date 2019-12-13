package sanaebadi.info.mvvmsample

import android.app.Application
import org.koin.android.ext.android.startKoin
import sanaebadi.info.mvvmsample.di.DependencyModules

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this, listOf(
                DependencyModules.appModule
            )
        )

    }
}
package ir.irezaa.cryptoprice

import android.app.Application
import ir.irezaa.cryptoprice.di.ApplicationComponent
import ir.irezaa.cryptoprice.di.DaggerApplicationComponent

class ApplicationClass : Application() {
    lateinit var appComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.create()
    }
}
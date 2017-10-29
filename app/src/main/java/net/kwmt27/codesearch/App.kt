package net.kwmt27.codesearch

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.kwmt27.codesearch.application.log.CrashLogTree
import net.kwmt27.codesearch.di.components.DaggerAppComponent
import timber.log.Timber


open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return  DaggerAppComponent.builder().application(this).build()
    }



    override fun onCreate() {
        super.onCreate()
        Timber.plant(CrashLogTree())
    }


}

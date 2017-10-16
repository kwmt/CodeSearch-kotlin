package net.kwmt27.codesearch

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.kwmt27.codesearch.presentation.internal.di.components.DaggerAppComponent


open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return  DaggerAppComponent.builder().application(this).build()
    }



    override fun onCreate() {
        super.onCreate()

    }


}

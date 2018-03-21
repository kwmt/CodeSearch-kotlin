package net.kwmt27.codesearch.application

import android.annotation.SuppressLint
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.kwmt27.codesearch.application.di.components.DaggerAppComponent
import net.kwmt27.codesearch.application.log.CrashLogTree
import rx_activity_result2.RxActivityResult
import timber.log.Timber

@SuppressLint("Registered")
open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(CrashLogTree())
        RxActivityResult.register(this)
    }
}

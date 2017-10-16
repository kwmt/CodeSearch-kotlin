package net.kwmt27.codesearch.presentation.internal.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.kwmt27.codesearch.App
import net.kwmt27.codesearch.presentation.internal.di.modules.AppModule
import net.kwmt27.codesearch.presentation.internal.di.modules.MainActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
    )
)
//interface AppComponent


interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build():AppComponent

    }
}
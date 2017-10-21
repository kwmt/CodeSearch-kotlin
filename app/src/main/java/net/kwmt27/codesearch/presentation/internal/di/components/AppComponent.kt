package net.kwmt27.codesearch.presentation.internal.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.kwmt27.codesearch.App
import net.kwmt27.codesearch.presentation.internal.di.modules.ActivityModule
import net.kwmt27.codesearch.presentation.internal.di.modules.AppModule
import net.kwmt27.codesearch.presentation.internal.di.modules.FragmentModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class
    )
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build():AppComponent

    }
}
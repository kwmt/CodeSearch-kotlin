package net.kwmt27.codesearch.application.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.kwmt27.codesearch.application.App
import net.kwmt27.codesearch.application.di.module.ActivityModule
import net.kwmt27.codesearch.application.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class
)
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}

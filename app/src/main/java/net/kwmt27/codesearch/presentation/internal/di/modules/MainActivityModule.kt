package net.kwmt27.codesearch.presentation.internal.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import net.kwmt27.codesearch.presentation.view.MainActivity


@Module(subcomponents = arrayOf(MainActivityModule.MainActivitySubComponent::class))
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindAndroidInjectorFactory(
            builder: MainActivityModule.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @ActivityScope
    @Subcomponent
    interface MainActivitySubComponent:AndroidInjector<MainActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainActivity>()
    }

}
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


@Module(subcomponents = arrayOf(ActivityModule.MainActivitySubComponent::class))
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindAndroidInjectorFactory(
            builder: ActivityModule.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @ActivityScope
    @Subcomponent
    interface MainActivitySubComponent:AndroidInjector<MainActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainActivity>()
    }

}
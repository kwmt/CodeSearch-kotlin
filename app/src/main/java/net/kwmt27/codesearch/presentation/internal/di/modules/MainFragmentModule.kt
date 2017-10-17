package net.kwmt27.codesearch.presentation.internal.di.modules

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import net.kwmt27.codesearch.presentation.view.MainFragment

@Module(subcomponents = arrayOf(MainFragmentModule.MainFragmentSubComponent::class))
abstract class MainFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    internal abstract fun bindMainFragmentAndroidInjectorFactory(
            builder: MainFragmentModule.MainFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @ActivityScope
    @Subcomponent
    interface MainFragmentSubComponent: AndroidInjector<MainFragment> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainFragment>()
    }

}
package net.kwmt27.codesearch.presentation.internal.di.modules

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.MainFragment

@Module(subcomponents = arrayOf(FragmentModule.MainFragmentSubComponent::class))
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    internal abstract fun bindMainFragmentAndroidInjectorFactory(
            builder: FragmentModule.MainFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @FragmentScope
    @Subcomponent
    interface MainFragmentSubComponent: AndroidInjector<MainFragment> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainFragment>()
    }

}
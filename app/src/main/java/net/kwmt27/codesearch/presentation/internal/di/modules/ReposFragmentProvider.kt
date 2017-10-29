package net.kwmt27.codesearch.presentation.internal.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.ReposFragment

@Module
abstract class ReposFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment


}

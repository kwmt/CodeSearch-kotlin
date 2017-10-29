package net.kwmt27.codesearch.application.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.ReposFragment

@Module
abstract class ReposFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment


}

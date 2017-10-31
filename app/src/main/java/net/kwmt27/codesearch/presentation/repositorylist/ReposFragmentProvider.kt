package net.kwmt27.codesearch.presentation.repositorylist

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.FragmentScope

@Module(includes = arrayOf(ReposFragmentModule::class))
abstract class ReposFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment


}

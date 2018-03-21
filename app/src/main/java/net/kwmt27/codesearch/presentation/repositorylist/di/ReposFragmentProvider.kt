package net.kwmt27.codesearch.presentation.repositorylist.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.repositorylist.ReposFragment

@Module(includes = arrayOf(ReposFragmentModule::class))
abstract class ReposFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment
}

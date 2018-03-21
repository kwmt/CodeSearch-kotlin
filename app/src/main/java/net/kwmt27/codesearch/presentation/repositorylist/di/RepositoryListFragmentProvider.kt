package net.kwmt27.codesearch.presentation.repositorylist.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.repositorylist.RepositoryListFragment

@Module(includes = arrayOf(RepositoryListFragmentModule::class))
abstract class RepositoryListFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): RepositoryListFragment
}

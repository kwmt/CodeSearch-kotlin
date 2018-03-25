package net.kwmt27.codesearch.application.di.module

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.repositorylist.RepositoryListFragment
import net.kwmt27.codesearch.presentation.repositorylist.RepositoryListNavigator
import javax.inject.Named

@FragmentScope
@Module
class RepositoryListFragmentModule {

    @Named("RepositoryListFragment")
    @Provides
    fun provideFragment(fragmentManager: FragmentManager): Fragment = fragmentManager.findFragmentByTag(RepositoryListFragment.TAG)

    @Provides
    fun provideReposNavigator(@Named("RepositoryListFragment") fragment: Fragment): RepositoryListNavigator = RepositoryListNavigator(fragment)
}

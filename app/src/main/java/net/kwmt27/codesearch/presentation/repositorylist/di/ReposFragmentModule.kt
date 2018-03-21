package net.kwmt27.codesearch.presentation.repositorylist.di

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.repositorylist.ReposFragment
import net.kwmt27.codesearch.presentation.repositorylist.ReposNavigator
import javax.inject.Named

@FragmentScope
@Module
class ReposFragmentModule {

    @Named("ReposFragment")
    @Provides
    fun provideFragment(fragmentManager: FragmentManager): Fragment = fragmentManager.findFragmentByTag(ReposFragment.TAG)

    @Provides
    fun provideReposNavigator(@Named("ReposFragment") fragment: Fragment): ReposNavigator = ReposNavigator(fragment)
}

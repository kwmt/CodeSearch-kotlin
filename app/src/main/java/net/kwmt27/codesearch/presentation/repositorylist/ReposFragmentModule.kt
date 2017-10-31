package net.kwmt27.codesearch.presentation.repositorylist

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.eventlist.Navigator

@FragmentScope
@Module
class ReposFragmentModule {

    @Provides
    fun provideFragment(fragmentManager: FragmentManager): Fragment = fragmentManager.findFragmentByTag(ReposFragment.TAG)

    @Provides
    fun provideNavigator(fragment: Fragment): Navigator = Navigator(fragment)

}

package net.kwmt27.codesearch.presentation.eventlist.di

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.eventlist.EventsFragment
import net.kwmt27.codesearch.presentation.eventlist.Navigator
import javax.inject.Named

@FragmentScope
@Module
class EventsFragmentModule {

    @Named("EventsFragment")
    @Provides
    fun provideFragment(fragmentManager: FragmentManager): Fragment = fragmentManager.findFragmentByTag(EventsFragment.TAG)

    @Provides
    @Named("EventsFragmentNavigator")
    fun provideNavigator(fragment: Fragment): Navigator = Navigator(fragment)

}

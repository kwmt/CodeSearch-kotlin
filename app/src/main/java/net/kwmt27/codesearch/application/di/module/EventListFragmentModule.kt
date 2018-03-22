package net.kwmt27.codesearch.application.di.module

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.eventlist.EventListFragment
import net.kwmt27.codesearch.presentation.eventlist.EventListNavigator
import javax.inject.Named

@FragmentScope
@Module
class EventListFragmentModule {

    @Named("EventListFragment")
    @Provides
    fun provideFragment(fragmentManager: FragmentManager): Fragment = fragmentManager.findFragmentByTag(EventListFragment.TAG)

    @Provides
    fun provideEventsNavigator(@Named("EventListFragment") fragment: Fragment): EventListNavigator = EventListNavigator(fragment)
}

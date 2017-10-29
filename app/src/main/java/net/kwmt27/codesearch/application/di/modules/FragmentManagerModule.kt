package net.kwmt27.codesearch.application.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.presentation.eventlist.Navigator
import net.kwmt27.codesearch.presentation.eventlist.EventsFragment
import net.kwmt27.codesearch.presentation.main.MainActivity


@Module
class FragmentManagerModule {


    @Provides
    fun provideFragmentManager(mainActivity: MainActivity) : Fragment = mainActivity.supportFragmentManager.findFragmentByTag(EventsFragment.TAG)

//    @Named("events")
//    @Provides
//    fun provideFragment(fragment: EventsFragment) : EventsFragment = fragment

//    @ActivityScope
//    @FragmentScope
    @Provides
    fun provideNavigator(fragment: Fragment): Navigator = Navigator(fragment)
}

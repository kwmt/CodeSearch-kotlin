package net.kwmt27.codesearch.presentation.internal.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.presentation.navigator.Navigator
import net.kwmt27.codesearch.presentation.view.EventsFragment
import net.kwmt27.codesearch.presentation.view.MainActivity


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

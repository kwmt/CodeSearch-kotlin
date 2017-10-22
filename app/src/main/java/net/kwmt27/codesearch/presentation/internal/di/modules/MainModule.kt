package net.kwmt27.codesearch.presentation.internal.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.EventsFragment
import net.kwmt27.codesearch.presentation.view.ReposFragment

@Module
abstract class MainModule {
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeEventsFragment(): EventsFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeReposFragment(): ReposFragment

}
//@Module(subcomponents = arrayOf(MainModule.MainFragmentSubComponent::class))
//abstract class MainModule {
//
//    @Binds
//    @IntoMap
//    @FragmentKey(EventsFragment::class)
//    internal abstract fun bindMainFragmentAndroidInjectorFactory(
//            builder: MainModule.MainFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
//
//    @FragmentScope
//    @Subcomponent
//    interface MainFragmentSubComponent: AndroidInjector<EventsFragment> {
//        @Subcomponent.Builder
//        abstract class Builder : AndroidInjector.Builder<EventsFragment>()
//    }
//
//}
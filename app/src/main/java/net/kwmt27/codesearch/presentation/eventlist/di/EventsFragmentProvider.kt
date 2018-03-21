package net.kwmt27.codesearch.presentation.eventlist.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.eventlist.EventListFragment

@Module(includes = arrayOf(EventsFragmentModule::class))
abstract class EventsFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeEventsFragment(): EventListFragment
}
//@Module(subcomponents = arrayOf(EventsFragmentProvider.EventsFragmentSubComponent::class))
//abstract class EventsFragmentProvider {
//
//    @Binds
//    @IntoMap
//    @FragmentKey(EventListFragment::class)
//    internal abstract fun bindEventsFragmentAndroidInjectorFactory(
//            builder: EventsFragmentProvider.EventsFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
//
//    @FragmentScope
//    @Subcomponent(modules = arrayOf(EventsFragmentModule::class))
//    interface EventsFragmentSubComponent : AndroidInjector<EventListFragment> {
//        @Subcomponent.Builder
//        abstract class Builder : AndroidInjector.Builder<EventListFragment>() {
//            abstract fun eventsFragmentModule(module:EventsFragmentModule)
//            override fun seedInstance(instance: EventListFragment) {
//                eventsFragmentModule(EventsFragmentModule(instance))
//            }
//        }
//    }
//
//}

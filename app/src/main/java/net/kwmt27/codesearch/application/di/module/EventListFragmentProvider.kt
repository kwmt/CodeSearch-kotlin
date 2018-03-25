package net.kwmt27.codesearch.application.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.FragmentScope
import net.kwmt27.codesearch.presentation.eventlist.EventListFragment

@Module(includes = [EventListFragmentModule::class])
abstract class EventListFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeEventsFragment(): EventListFragment
}
//@Module(subcomponents = arrayOf(EventListFragmentProvider.EventsFragmentSubComponent::class))
//abstract class EventListFragmentProvider {
//
//    @Binds
//    @IntoMap
//    @FragmentKey(EventListFragment::class)
//    internal abstract fun bindEventsFragmentAndroidInjectorFactory(
//            builder: EventListFragmentProvider.EventsFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
//
//    @FragmentScope
//    @Subcomponent(modules = arrayOf(EventListFragmentModule::class))
//    interface EventsFragmentSubComponent : AndroidInjector<EventListFragment> {
//        @Subcomponent.Builder
//        abstract class Builder : AndroidInjector.Builder<EventListFragment>() {
//            abstract fun eventsFragmentModule(module:EventListFragmentModule)
//            override fun seedInstance(instance: EventListFragment) {
//                eventsFragmentModule(EventListFragmentModule(instance))
//            }
//        }
//    }
//
//}

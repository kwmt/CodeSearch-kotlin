package net.kwmt27.codesearch.presentation.internal.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.EventsFragment

@Module
abstract class EventsFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(
            EventsFragmentModule::class))
    internal abstract fun contributeEventsFragment(): EventsFragment

}
//@Module(subcomponents = arrayOf(EventsFragmentProvider.EventsFragmentSubComponent::class))
//abstract class EventsFragmentProvider {
//
//    @Binds
//    @IntoMap
//    @FragmentKey(EventsFragment::class)
//    internal abstract fun bindEventsFragmentAndroidInjectorFactory(
//            builder: EventsFragmentProvider.EventsFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
//
//    @FragmentScope
//    @Subcomponent(modules = arrayOf(EventsFragmentModule::class))
//    interface EventsFragmentSubComponent : AndroidInjector<EventsFragment> {
//        @Subcomponent.Builder
//        abstract class Builder : AndroidInjector.Builder<EventsFragment>() {
//            abstract fun eventsFragmentModule(module:EventsFragmentModule)
//            override fun seedInstance(instance: EventsFragment) {
//                eventsFragmentModule(EventsFragmentModule(instance))
//            }
//        }
//    }
//
//}

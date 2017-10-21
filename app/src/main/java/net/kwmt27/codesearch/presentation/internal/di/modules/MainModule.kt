package net.kwmt27.codesearch.presentation.internal.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.view.EventsFragment

@Module
abstract class MainModule {
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): EventsFragment

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
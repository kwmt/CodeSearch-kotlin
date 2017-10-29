package net.kwmt27.codesearch.application.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.ActivityScope
import net.kwmt27.codesearch.presentation.eventlist.di.EventsFragmentProvider
import net.kwmt27.codesearch.presentation.main.MainActivity

/**
 * ActivityへのInject
 *
 *
 *
 * ## 参考
 * - https://google.github.io/dagger/android.html
 * - http://y-anz-m.blogspot.jp/2017/07/android-dagger-3-android-support.html
 * - https://qiita.com/satorufujiwara/items/0f95ccfc3820d3ee1370
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            EventsFragmentProvider::class,
            ReposFragmentProvider::class,
            FragmentManagerModule::class
    ))
    internal abstract fun contributeMainActivity(): MainActivity

}

/**
 * [@SubComponent]を使うパターン
 */
//@Module(subcomponents = arrayOf(ActivityModule.MainActivitySubComponent::class))
//abstract class ActivityModule {
//
//    @Binds
//    @IntoMap
//    @ActivityKey(MainActivity::class)
//    internal abstract fun bindMainActivityAndroidInjectorFactory(
//            builder: ActivityModule.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
//
//    @ActivityScope
//    @Subcomponent(modules = arrayOf(ActivityModule_temp::class, EventsFragmentProvider::class))
//    interface MainActivitySubComponent:AndroidInjector<MainActivity> {
//
//        @Subcomponent.Builder
//        abstract class Builder : AndroidInjector.Builder<MainActivity>() {
//            abstract fun activityModule(activityModule: ActivityModule_temp)
//            override fun seedInstance(instance: MainActivity) {
//                activityModule(ActivityModule_temp(instance))
//            }
//
//        }
//
//
//
//    }
//
//}

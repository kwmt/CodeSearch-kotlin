package net.kwmt27.codesearch.application.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.application.di.ActivityScope
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
abstract class MainActivityProvider {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        EventListFragmentProvider::class,
        RepositoryListFragmentProvider::class,
        MainActivityModule::class
    ])
    internal abstract fun contributeMainActivity(): MainActivity
}

/**
 * [@SubComponent]を使うパターン
 */
//@Module(subcomponents = arrayOf(MainActivityProvider.MainActivitySubComponent::class))
//abstract class MainActivityProvider {
//
//    @Binds
//    @IntoMap
//    @ActivityKey(MainActivity::class)
//    internal abstract fun bindMainActivityAndroidInjectorFactory(
//            builder: MainActivityProvider.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
//
//    @ActivityScope
//    @Subcomponent(modules = arrayOf(ActivityModule_temp::class, EventListFragmentProvider::class))
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

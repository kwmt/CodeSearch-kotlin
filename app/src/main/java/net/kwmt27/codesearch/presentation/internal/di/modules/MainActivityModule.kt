package net.kwmt27.codesearch.presentation.internal.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import net.kwmt27.codesearch.presentation.view.MainActivity

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
//@Module
//abstract class MainActivityModule {
//
//    @ActivityScope
//    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
//    internal abstract fun contributeMainActivity(): MainActivity
//
//}

/**
 * [@SubComponent]を使うパターン
 */
@Module(subcomponents = arrayOf(MainActivityModule.MainActivitySubComponent::class))
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityAndroidInjectorFactory(
            builder: MainActivityModule.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @ActivityScope
    @Subcomponent(modules = arrayOf(ActivityModule::class, MainModule::class))
    interface MainActivitySubComponent:AndroidInjector<MainActivity> {

        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainActivity>() {
            abstract fun activityModule(activityModule: ActivityModule)
            override fun seedInstance(instance: MainActivity) {
                activityModule(ActivityModule(instance))
            }

        }



    }

}

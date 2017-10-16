package net.kwmt27.codesearch.presentation.internal.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.internal.di.ActivityScope
import net.kwmt27.codesearch.presentation.view.MainActivity


@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector//(modules = arrayOf(MainModule::class))
    abstract fun mainActivity(): MainActivity


}
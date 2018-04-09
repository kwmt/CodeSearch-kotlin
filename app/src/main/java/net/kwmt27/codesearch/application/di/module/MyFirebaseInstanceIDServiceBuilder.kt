package net.kwmt27.codesearch.application.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.service.push.MyFirebaseInstanceIDService

@Module
abstract class MyFirebaseInstanceIDServiceBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeMyFirebaseInstanceIDService(): MyFirebaseInstanceIDService
}
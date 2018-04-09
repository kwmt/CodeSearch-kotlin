package net.kwmt27.codesearch.application.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kwmt27.codesearch.presentation.service.push.PushService

@Module
abstract class PushServiceBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributePushService(): PushService
}
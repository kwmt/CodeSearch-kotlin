package net.kwmt27.codesearch.application.di.module

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.presentation.main.MainActivity

@Module
class MainActivityModule {

    @Provides
    fun provideFragmentManager(mainActivity: MainActivity): FragmentManager = mainActivity.supportFragmentManager
}

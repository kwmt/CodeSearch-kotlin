package net.kwmt27.codesearch.presentation.main

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideFragmentManager(mainActivity: MainActivity): FragmentManager = mainActivity.supportFragmentManager
}

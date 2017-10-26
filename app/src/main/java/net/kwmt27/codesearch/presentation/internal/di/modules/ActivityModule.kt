package net.kwmt27.codesearch.presentation.internal.di.modules

import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides


/**
 * Created by kwmt on 2017/10/26.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    fun provideLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(activity)
    }

    @Provides
    fun provideAppCompatActivity() : AppCompatActivity = activity
}

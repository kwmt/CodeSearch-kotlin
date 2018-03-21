package net.kwmt27.codesearch.application.di.module

import android.content.Context
import android.support.annotation.NonNull
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.BuildConfig
import net.kwmt27.codesearch.application.App
import net.kwmt27.codesearch.domain.repository.EventListRepository
import net.kwmt27.codesearch.domain.repository.LoginRepository
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.extension.printCurlString
import net.kwmt27.codesearch.infrastructure.repository.EventListDataRepository
import net.kwmt27.codesearch.infrastructure.repository.LoginRepositoryImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides
    fun provideContext(app: App): Context = app

//    @ActivityScope
//    @Provides
//    fun provideNavigator(): RepositoryListNavigator = RepositoryListNavigator()

    @Singleton
    @Provides
    fun provideEventsRepository(eventsDataRepository: EventListDataRepository): EventListRepository = eventsDataRepository

    @Singleton
    @Provides
    fun provideLoginRepository(githubApi: GithubApi): LoginRepository {
        return LoginRepositoryImpl(githubApi)
    }

    @Singleton
    @Provides
    fun provideGithubApi(client: OkHttpClient, moshi: Moshi): GithubApi {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(GithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
            OkHttpClient.Builder().addInterceptor(CurlHttpLoggingInterceptor()).build()

    private class CurlHttpLoggingInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(@NonNull chain: Interceptor.Chain): Response =
                chain.proceed(chain.request().apply { printCurlString() })
    }
}

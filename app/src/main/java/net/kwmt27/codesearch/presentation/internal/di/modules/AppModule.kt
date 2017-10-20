package net.kwmt27.codesearch.presentation.internal.di.modules


import android.content.Context
import android.support.annotation.NonNull
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.App
import net.kwmt27.codesearch.BuildConfig
import net.kwmt27.codesearch.data.api.GithubApi
import net.kwmt27.codesearch.data.repository.EventsDataRepository
import net.kwmt27.codesearch.data.util.ApiUtil
import net.kwmt27.codesearch.domain.repository.EventsRepository
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
    fun provideContext(app: App):Context = app

//    @ActivityScope
//    @Provides
//    fun provideNavigator(): Navigator = Navigator()

    @Singleton
    @Provides
    fun provideEventsRepository(eventsDataRepository: EventsDataRepository): EventsRepository = eventsDataRepository


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
        override fun intercept(@NonNull chain: Interceptor.Chain): Response {
            val request = chain.request()
            ApiUtil.printCurlString(request)
            return chain.proceed(request)
        }
    }

}

package net.kwmt27.codesearch.presentation.internal.di.modules


import android.content.Context
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import net.kwmt27.codesearch.BuildConfig
import net.kwmt27.codesearch.data.api.GithubApi
import net.kwmt27.codesearch.App
import net.kwmt27.codesearch.util.ApiUtil
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

//    @Singleton
//    @Binds
//    abstract fun provideUserRepository(userDataRepository: UserDataRepository):UserRepository


    @Singleton
    @Provides
    fun provideGithubApi(client: OkHttpClient): GithubApi {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(GithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
            OkHttpClient.Builder().addInterceptor(CurlHttpLoggingInterceptor()).build()


//    @Singleton
//    @Provides
//    fun provideFcmRepository(client: GithubClient): FcmRepository {
//        return FcmRepository(client)
//    }
//
//


    private class CurlHttpLoggingInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(@NonNull chain: Interceptor.Chain): Response {
            val request = chain.request()
            ApiUtil.printCurlString(request)
            return chain.proceed(request)
        }
    }
    //    @Singleton
    //    @Provides
    //    public AnalyticsManager provideAnalyticsManager() {
    //        return new AnalyticsManager(context);
    //    }
    //
}

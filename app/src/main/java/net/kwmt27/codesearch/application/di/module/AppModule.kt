package net.kwmt27.codesearch.application.di.module

import android.content.Context
import android.support.annotation.NonNull
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import net.kwmt27.codesearch.BuildConfig
import net.kwmt27.codesearch.application.App
import net.kwmt27.codesearch.domain.repository.EventListRepository
import net.kwmt27.codesearch.domain.repository.LoginRepository
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCaseImpl
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.datesource.GithubApiDataSource
import net.kwmt27.codesearch.infrastructure.datesource.LoginRepositoryImpl
import net.kwmt27.codesearch.infrastructure.entity.mapper.EventEntityModelMapper
import net.kwmt27.codesearch.infrastructure.extension.curl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.IOException
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

//    @ActivityScope
//    @Provides
//    fun provideNavigator(): RepositoryListNavigator = RepositoryListNavigator()

    @Singleton
    @Provides
    fun provideEventEntityModelMapper() = EventEntityModelMapper()

    @Singleton
    @Provides
    fun provideEventListRepository(
        githubApi: GithubApi,
        eventEntityModelMapper: EventEntityModelMapper
    ): EventListRepository = GithubApiDataSource(githubApi, eventEntityModelMapper)

    @Provides
    fun provideFetchEventListUseCase(eventListRepository: EventListRepository):
            FetchEventListUseCase = FetchEventListUseCaseImpl(eventListRepository)

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
            OkHttpClient.Builder()
                    .addInterceptor(CurlHttpLoggingInterceptor())
                    .addInterceptor(ApiResponseInterceptor())
                    .build()

    private class CurlHttpLoggingInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(@NonNull chain: Interceptor.Chain): Response =
                chain.proceed(chain.request().apply { Timber.d(curl()) })
    }

    /**
     * APIの共通レスポンスを捕捉するクラス
     */
    internal class ApiResponseInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(@NonNull chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            val body = response.body()?.string() ?: throw UnknownError()
            Timber.d("codesearch response: $body")
//
//            // TODO: エラー処理
//            val json = response.body()?.string() ?: throw UnknownException()
//            val jsonAdapter = moshi.adapter(ApiCommonResponseEntity::class.java)
//            // TODO: レスポンス書式エラーを正しく実装する
//            val entity = jsonAdapter.fromJson(json)
//                    ?: throw UnknownException("APIレスポンスが正しくありません:$json")
//            if (!entity.isOk) {
//                // TODO: APIエラーを正しく実装する
//                throw UnknownException("APIエラー(${entity.statusCode})")
//            }
            return response.newBuilder().body(ResponseBody.create(response.body()?.contentType(), body)).build()
//            return response.newBuilder().body(ResponseBody.create(response.body()?.contentType(), json)).build()
        }
    }
}

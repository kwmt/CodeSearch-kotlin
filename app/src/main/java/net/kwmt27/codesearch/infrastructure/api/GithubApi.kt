package net.kwmt27.codesearch.infrastructure.api

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("users/{user}/received_events")
    fun fetchEvent(@Path("user") user: String, @Query("page") page: Int): Single<List<EventEntity>>

    @POST("/authorizations")
    fun authorizations(
            @Field("scopes") scopes: List<String>,
            @Field("note") note: String,
            @Field("note_ur") noteUr: String

    ): Single<String>
}

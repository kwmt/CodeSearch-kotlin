package net.kwmt27.codesearch.data.api


import io.reactivex.Single
import net.kwmt27.codesearch.data.entity.EventEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("users/{user}/received_events")
    fun fetchEvent(@Path("user") user: String, @Query("page") page: Int): Single<List<EventEntity>>

}

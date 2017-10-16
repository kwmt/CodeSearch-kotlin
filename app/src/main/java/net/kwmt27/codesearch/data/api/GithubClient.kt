package net.kwmt27.codesearch.data.api


import net.kwmt27.codesearch.data.entity.MessageEntity

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Single
import retrofit2.Response

@Singleton
class GithubClient @Inject
constructor(private val githubApi: GithubApi) {

    fun updateDevice(token: String, uuid: String): Single<Response<MessageEntity>> {
        return githubApi.updateDevice(token, uuid, GithubApi.PLATFORM)
    }
}

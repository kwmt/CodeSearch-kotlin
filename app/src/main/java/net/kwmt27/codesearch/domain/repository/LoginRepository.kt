package net.kwmt27.codesearch.domain.repository

import io.reactivex.Single

interface LoginRepository {

    fun login(userId: String, password: String): Single<String>
}

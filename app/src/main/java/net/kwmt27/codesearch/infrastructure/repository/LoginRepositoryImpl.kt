package net.kwmt27.codesearch.infrastructure.repository

import io.reactivex.Single
import net.kwmt27.codesearch.domain.repository.LoginRepository
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
        private val githubApi: GithubApi
) : LoginRepository {

    override fun login(userId: String, password: String): Single<String> {
        // TODO
        return githubApi.authorizations(listOf("scope"), "note", "noteUr")
    }
}

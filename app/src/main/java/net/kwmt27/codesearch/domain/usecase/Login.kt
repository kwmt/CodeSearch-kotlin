package net.kwmt27.codesearch.domain.usecase

import io.reactivex.Single
import net.kwmt27.codesearch.domain.repository.LoginRepository
import javax.inject.Inject

/**
 * ログインする
 */
class Login @Inject constructor(
    private val loginRepository: LoginRepository
) : UseCase<Login.Companion.Params, String>() {

    companion object {
        data class Params(val userId: String, val password: String)
    }

    override fun buildRepository(param: Params): Single<String> {
        return loginRepository.login(param.userId, param.password)
    }
}

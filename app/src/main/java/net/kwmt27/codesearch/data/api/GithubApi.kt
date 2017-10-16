package net.kwmt27.codesearch.data.api


import io.reactivex.Single
import net.kwmt27.codesearch.data.entity.MessageEntity
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GithubApi {

    /**
     * 端末情報を更新する。
     * @param token registration token
     * @param instanceId FirebaseのinstanceIdをuuidとして使用しています。FirebaseのInstanceIdはuuidと同様のタイミングでしか変更されないため。
     * https://firebase.google.com/docs/reference/android/com/google/firebase/iid/FirebaseInstanceId.html
     * @param platform "android" (固定値) を送信する
     * ※Retrofitではconstant fieldをサポートしていない。
     * https://github.com/square/retrofit/issues/1887#issuecomment-229363584
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/api/register-notification")
    fun updateDevice(@Field("registration_token") token: String, @Field("instance_id") instanceId: String, @Field("platform") platform: String): Single<Response<MessageEntity>>

    companion object {
        val PLATFORM = "android"
    }
}

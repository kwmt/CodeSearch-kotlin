package net.kwmt27.codesearch.infrastructure.entity

import com.squareup.moshi.Json

class ActorEntity {

    var id: Int = 0
    var login: String = ""
    @Json(name = "display_login")
    var displayLogin = ""
    @Json(name = "gravatar_id")
    var gravatarId: String = ""
    var url: String = ""
    @Json(name = "avatar_url")
    var avatarUrl: String = ""
}

package net.kwmt27.codesearch.domain.model

import net.kwmt27.codesearch.domain.model.valueobject.GithubUser

open class EventModel {

    var itemType: ItemType = ItemType.Normal
    var isPublic: Boolean = false

    var githubUser: GithubUser = GithubUser("", "")


}
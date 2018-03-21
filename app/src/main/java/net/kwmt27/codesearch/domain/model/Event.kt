package net.kwmt27.codesearch.domain.model

open class Event {

    var itemType: ItemType = ItemType.Normal
    var isPublic: Boolean = false

    var githubUser: GithubUser = GithubUser("", "")
}

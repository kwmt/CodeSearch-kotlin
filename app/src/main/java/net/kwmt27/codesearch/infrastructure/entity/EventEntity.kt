package net.kwmt27.codesearch.infrastructure.entity

class EventEntity {

    var id: String = ""
    var type: String = ""
    var public: Boolean = false
    var actor: ActorEntity = ActorEntity()
}

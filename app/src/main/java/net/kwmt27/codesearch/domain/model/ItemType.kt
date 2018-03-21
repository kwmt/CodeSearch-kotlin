package net.kwmt27.codesearch.domain.model

enum class ItemType(val typeId: Int) {
    Normal(0),
    Progress(1),
    Ad(2);

    companion object {
        fun valueOf(typeId: Int): ItemType {
            val filtered = ItemType.values().filter { it.typeId == typeId }.firstOrNull()
            return filtered
                    ?: throw IllegalArgumentException("no such enum object for the id: " + typeId)
        }
    }
}

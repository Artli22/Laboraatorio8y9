package com.limaa.lab9moviles.data

class LocationDb {
    private val locations: List<RickMortyLocation> = listOf(
        RickMortyLocation(1, "Earth (C-137)", "Planet", "Dimension C-137"),
        RickMortyLocation(2, "Abadango", "Cluster", "unknown"),
        RickMortyLocation(3, "Citadel of Ricks", "Space station", "unknown"),
        RickMortyLocation(4, "Worldender's lair", "Planet", "unknown"),
        RickMortyLocation(5, "Anatomy Park", "Microverse", "Dimension C-137"),
        RickMortyLocation(6, "Interdimensional Cable", "TV", "unknown"),
        RickMortyLocation(7, "Immortality Field Resort", "Resort", "unknown"),
        RickMortyLocation(8, "Post-Apocalyptic Earth", "Planet", "Post-Apocalyptic Dimension"),
        RickMortyLocation(9, "Purge Planet", "Planet", "Replacement Dimension"),
        RickMortyLocation(10, "Venzenulon 7", "Planet", "unknown"),
        RickMortyLocation(11, "Bepis 9", "Planet", "unknown"),
        RickMortyLocation(12, "Cronenberg Earth", "Planet", "Cronenberg Dimension"),
        RickMortyLocation(13, "Nuptia 4", "Planet", "unknown"),
        RickMortyLocation(14, "Giant's Town", "Fantasy town", "Fantasy Dimension"),
        RickMortyLocation(15, "Bird World", "Planet", "unknown"),
        RickMortyLocation(16, "St. Gloopy Noops Hospital", "Space station", "unknown"),
        RickMortyLocation(17, "Earth (5-126)", "Planet", "Dimension 5-126"),
        RickMortyLocation(18, "Mr. Goldenfold's dream", "Dream", "Dimension C-137"),
        RickMortyLocation(19, "Gromflom Prime", "Planet", "Replacement Dimension"),
        RickMortyLocation(20, "Earth (Replacement Dimension)", "Planet", "Replacement Dimension")
    )

    fun getAllLocations(): List<RickMortyLocation> {
        return locations
    }

    fun getLocationById(id: Int): RickMortyLocation {
        return locations.first { it.id == id }
    }
}
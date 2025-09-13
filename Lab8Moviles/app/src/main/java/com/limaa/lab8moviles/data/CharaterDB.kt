package com.limaa.lab8moviles.data

class CharacterDb {
    private val characters: List<RickMortyCharacter> = listOf(
        RickMortyCharacter(1, "Rick Sanchez", "Alive", "Human", "Male"),
        RickMortyCharacter(2, "Morty Smith", "Alive", "Human", "Male"),
        RickMortyCharacter(3, "Summer Smith", "Alive", "Human", "Female"),
        RickMortyCharacter(4, "Beth Smith", "Alive", "Human", "Female"),
        RickMortyCharacter(5, "Jerry Smith", "Alive", "Human", "Male"),
        RickMortyCharacter(6, "Abadango Cluster Princess", "Alive", "Alien", "Female"),
        RickMortyCharacter(7, "Abradolf Lincler", "unknown", "Human", "Male"),
        RickMortyCharacter(8, "Adjudicator Rick", "Dead", "Human", "Male"),
        RickMortyCharacter(9, "Agency Director", "Dead", "Human", "Male"),
        RickMortyCharacter(10, "Alan Rails", "Dead", "Human", "Male"),
        RickMortyCharacter(11, "Albert Einstein", "Dead", "Human", "Male"),
        RickMortyCharacter(12, "Alexander", "Dead", "Human", "Male"),
        RickMortyCharacter(13, "Alien Googah", "unknown", "Alien", "unknown"),
        RickMortyCharacter(14, "Alien Morty", "unknown", "Alien", "Male"),
        RickMortyCharacter(15, "Alien Rick", "unknown", "Alien", "Male"),
        RickMortyCharacter(16, "Amish Cyborg", "Dead", "Alien", "Male"),
        RickMortyCharacter(17, "Annie", "Alive", "Human", "Female"),
        RickMortyCharacter(18, "Antenna Morty", "Alive", "Human", "Male"),
        RickMortyCharacter(19, "Antenna Rick", "unknown", "Human", "Male"),
        RickMortyCharacter(20, "Ants in my Eyes Johnson", "unknown", "Human", "Male")
    )

    fun getAllCharacters(): List<RickMortyCharacter> {
        return characters
    }

    fun getCharacterById(id: Int): RickMortyCharacter {
        return characters.first { it.id == id }
    }
}
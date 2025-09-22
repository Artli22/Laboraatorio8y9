package com.limaa.lab9moviles.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Profile

@Serializable
object CharactersGraph

@Serializable
object LocationsGraph

@Serializable
object Characters

@Serializable
data class CharacterDetail(val characterId: Int)

@Serializable
object Locations

@Serializable
data class LocationDetail(val locationId: Int)
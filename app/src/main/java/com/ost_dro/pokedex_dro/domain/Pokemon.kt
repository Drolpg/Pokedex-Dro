package com.ost_dro.pokedex_dro.domain

data class Pokemon(
    val imageUrl: String,
    val number: Int,
    val name: String,
    val types: List<PokemonType>
) {
    val formatterdNumber = number.toString().padStart(3, '0')
}


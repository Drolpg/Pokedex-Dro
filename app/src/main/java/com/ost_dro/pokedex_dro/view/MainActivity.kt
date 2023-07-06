package com.ost_dro.pokedex_dro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ost_dro.pokedex_dro.R
import com.ost_dro.pokedex_dro.domain.Pokemon
import com.ost_dro.pokedex_dro.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_Pokemons)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png",
            4,
            "Charmander",
            listOf(
                PokemonType("Fire"),
                PokemonType("Fire")
            )
        )
        val pokemons = listOf(
            charmander,
            charmander,
            charmander,
            charmander,
            charmander
        )

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}
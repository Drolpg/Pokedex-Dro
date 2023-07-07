package com.ost_dro.pokedex_dro.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ost_dro.pokedex_dro.R
import com.ost_dro.pokedex_dro.domain.Pokemon
import java.util.Locale

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.iv_pokemon)
            val tvNumber = findViewById<TextView>(R.id.tv_number)
            val tvName = findViewById<TextView>(R.id.tv_name)
            val tvType1 = findViewById<TextView>(R.id.tv_type1)
            val tvType2 = findViewById<TextView>(R.id.tv_type2)

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)
            }

            tvNumber.text = "N° ${item.formattedNumber}"
            tvName.text = item.name.replaceFirstChar { it.uppercase() }
            tvType1.text = item.types[0].name.replaceFirstChar { it.uppercase() }


            if (item.types.size > 1) {
                tvType2.visibility = View.VISIBLE
                tvType2.text = item.types[1].name.replaceFirstChar { it.uppercase() }
            } else {
                tvType2.visibility = View.GONE
            }

            val drawable = when (tvType1.text) {
                "Fire" -> R.drawable.rounded_background_fire
                "Water" -> R.drawable.rounded_background_water
                "Grass" -> R.drawable.rounded_background_glass
                "Poison" -> R.drawable.rounded_background_poison
                "Bug" -> R.drawable.rounded_background_bug
                "Electric" -> R.drawable.rounded_background_eletric
                "Rock" -> R.drawable.rounded_background_rock
                "Ghost" -> R.drawable.rounded_background_ghost
                "Ground" -> R.drawable.rounded_background_rock
                else -> R.drawable.rounded_background
            }

            ivPokemon.setBackgroundResource(drawable)
            tvType1.setBackgroundResource(drawable)
            tvType2.setBackgroundResource(drawable)

        }
    }

}
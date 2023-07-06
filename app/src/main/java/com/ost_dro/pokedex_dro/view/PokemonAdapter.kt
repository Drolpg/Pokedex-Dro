package com.ost_dro.pokedex_dro.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ost_dro.pokedex_dro.R
import com.ost_dro.pokedex_dro.domain.Pokemon

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
        fun bindView(item: Pokemon) = with(itemView){
            val ivPokemon = findViewById<ImageView>(R.id.iv_pokemon)
            val tvNumber = findViewById<TextView>(R.id.tv_number)
            val tvName = findViewById<TextView>(R.id.tv_name)
            val tvType1 = findViewById<TextView>(R.id.tv_type1)
            val tvType2 = findViewById<TextView>(R.id.tv_type2)

            // TODO: Load imag with Glide

            tvNumber.text = "N° ${item.formatterdNumber}"
            tvName.text = item.name
            tvType1.text = item.types[0].name

            if (item.types.size > 1){
                tvType2.visibility = View.VISIBLE
                tvType2.text = item.types[1].name
            } else{
                tvType2.visibility = View.GONE
            }

        }
    }

}
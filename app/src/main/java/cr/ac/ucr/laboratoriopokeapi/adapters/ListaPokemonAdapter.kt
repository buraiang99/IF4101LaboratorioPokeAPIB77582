package cr.ac.ucr.laboratoriopokeapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cr.ac.ucr.laboratoriopokeapi.R
import cr.ac.ucr.laboratoriopokeapi.adapters.ListaPokemonAdapter.SearchViewHolder
import cr.ac.ucr.laboratoriopokeapi.modelos.PokeResult
import cr.ac.ucr.laboratoriopokeapi.modelos.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class ListaPokemonAdapter(val pokemonClick: (Int) -> Unit) : RecyclerView.Adapter<ListaPokemonAdapter.SearchViewHolder>() {

    var listaPokemon: List<PokeResult> = emptyList<PokeResult>()
    class SearchViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent,false))
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    fun setData(list: List<PokeResult>){
        listaPokemon = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = listaPokemon[position]
        holder.itemView.pokeNombre.text = "${pokemon.name}"
        holder.itemView.pokeId.text = "#${position + 1}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }
}
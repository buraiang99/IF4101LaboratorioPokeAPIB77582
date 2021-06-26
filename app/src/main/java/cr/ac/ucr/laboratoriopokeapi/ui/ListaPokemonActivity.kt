package cr.ac.ucr.laboratoriopokeapi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cr.ac.ucr.laboratoriopokeapi.R
import cr.ac.ucr.laboratoriopokeapi.adapters.ListaPokemonAdapter
import cr.ac.ucr.laboratoriopokeapi.modelos.ListaPokemonModel
import kotlinx.android.synthetic.main.activity_lista_pokemon.*

class
ListaPokemonActivity : AppCompatActivity() {

    private lateinit var viewModel:ListaPokemonModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pokemon)
        viewModel = ViewModelProvider(this).get(ListaPokemonModel::class.java)
        init()
    }

    private fun init() {
        lista_pokemon_recycler.layoutManager = LinearLayoutManager(this)
        lista_pokemon_recycler.adapter = ListaPokemonAdapter{
            val intent = Intent(this, PokeinfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this, Observer { list ->
            (lista_pokemon_recycler.adapter as ListaPokemonAdapter).setData(list)
        })
    }
}
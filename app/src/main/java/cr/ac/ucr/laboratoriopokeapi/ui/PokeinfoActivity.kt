package cr.ac.ucr.laboratoriopokeapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import cr.ac.ucr.laboratoriopokeapi.R
import cr.ac.ucr.laboratoriopokeapi.modelos.InfoPokemonModel
import kotlinx.android.synthetic.main.activity_poke_information.*
import kotlinx.android.synthetic.main.item_pokemon.*

class PokeinfoActivity:AppCompatActivity() {

    lateinit var viewModel: InfoPokemonModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_information)

        viewModel = ViewModelProvider(this).get(InfoPokemonModel::class.java)

        init()
    }
    private fun init() {
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            nombreInfoPoke.text = pokemon.name
            numeroPoke.text = "${pokemon.id}"
            alturaPoke.text = "Altura: ${pokemon.height/10.0}m"
            pesoPoke.text = "Peso: ${pokemon.weight/10.0}"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(imagenPoke)
        })
    }
}
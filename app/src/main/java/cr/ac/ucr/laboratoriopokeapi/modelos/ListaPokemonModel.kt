package cr.ac.ucr.laboratoriopokeapi.modelos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cr.ac.ucr.laboratoriopokeapi.PokeAPI.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaPokemonModel(): ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val servicio: API = retrofit.create(API::class.java)

    val pokemonList = MutableLiveData<List<PokeResult>>()

    fun getPokemonList(){
        val call = servicio.getPokemonList(890,0)

        call.enqueue(object : Callback<PokemonAPI> {
            override fun onResponse(call: Call<PokemonAPI>, response: Response<PokemonAPI>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<PokemonAPI>, t: Throwable) {
                call.cancel()
            }

        })
    }
}
package cr.ac.ucr.laboratoriopokeapi.PokeAPI

import cr.ac.ucr.laboratoriopokeapi.modelos.Pokemon
import cr.ac.ucr.laboratoriopokeapi.modelos.PokemonAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonAPI>
}
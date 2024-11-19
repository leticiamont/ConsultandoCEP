package br.edu.fatecpg.consultandocep.interfaces

import br.edu.fatecpg.consultandocep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ConsultaCepIntface {

    @GET("{cep}/json")
    fun buscaEndereco(@Path("cep") cep:String): Call<Endereco>
}
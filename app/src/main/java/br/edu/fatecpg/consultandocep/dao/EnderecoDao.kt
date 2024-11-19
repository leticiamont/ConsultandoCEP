package br.edu.fatecpg.consultandocep.dao

import android.content.Context
import android.widget.Toast
import br.edu.fatecpg.consultandocep.interfaces.ConsultaCepIntface
import br.edu.fatecpg.consultandocep.interfaces.EnderecoIntface
import br.edu.fatecpg.consultandocep.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnderecoDao : EnderecoIntface {
    companion object {
        private val enderecos: MutableList<Endereco> = mutableListOf()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val enderecoService = retrofit.create(ConsultaCepIntface::class.java)

    override fun BuscaEndereco(context: Context, cep: String) {
        val call = enderecoService.buscaEndereco(cep)
        call.enqueue(object:Callback<Endereco>{
            override fun onResponse(p0: Call<Endereco>, p1: Response<Endereco>) {
                if(p1.isSuccessful){
                    val endereco = p1.body()
                    if(endereco != null && !endereco.cep.isNullOrEmpty()){
                        enderecos.add(endereco)
                        Toast.makeText(context, "CEP Localizado!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "CEP não encontrado", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(p0: Call<Endereco>, p1: Throwable) {
                println("Falha na conexão: ${p1.message}")
                Toast.makeText(context, "Falha na conexão", Toast.LENGTH_SHORT).show()
            }

        })

    }

    override fun MostrarEndereco(): List<Endereco> {
        println("Mostrando endereços: $enderecos")
        return enderecos
    }
}
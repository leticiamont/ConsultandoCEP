package br.edu.fatecpg.consultandocep.interfaces

import android.content.Context
import br.edu.fatecpg.consultandocep.model.Endereco

interface EnderecoIntface {
    fun BuscaEndereco(context: Context, cep: String)
    fun MostrarEndereco():List<Endereco>
}
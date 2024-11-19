package br.edu.fatecpg.consultandocep.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.consultandocep.R
import br.edu.fatecpg.consultandocep.model.Endereco

class EnderecoAdapter(private val enderecos: List<Endereco>): RecyclerView.Adapter<EnderecoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtCep = itemView.findViewById<TextView>(R.id.txt_cep)
        val txtLogadouro = itemView.findViewById<TextView>(R.id.txt_long)
        val txtBairro = itemView.findViewById<TextView>(R.id.txt_bairro)
        val txtLocalidade = itemView.findViewById<TextView>(R.id.txt_local)
        val txtUf = itemView.findViewById<TextView>(R.id.txt_uf)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_endereco, parent,false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val endereco = enderecos[position]

        holder.txtCep.text = "CEP: ${endereco.cep}"
        holder.txtLogadouro.text = "Rua: ${endereco.logradouro}"
        holder.txtBairro.text = "Bairro: ${endereco.bairro}"
        holder.txtLocalidade.text = "Cidade: ${endereco.localidade}"
        holder.txtUf.text = "UF: ${endereco.uf}"
    }

    override fun getItemCount(): Int {
        return enderecos.size
    }

}
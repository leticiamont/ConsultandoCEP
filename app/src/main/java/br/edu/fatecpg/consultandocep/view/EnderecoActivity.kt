package br.edu.fatecpg.consultandocep.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.consultandocep.R
import br.edu.fatecpg.consultandocep.adapter.EnderecoAdapter
import br.edu.fatecpg.consultandocep.dao.EnderecoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EnderecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cep)
        val enderecoDao = EnderecoDao()
        val rvLista = findViewById<RecyclerView>(R.id.rv_lista)

        val enderecos = enderecoDao.MostrarEndereco()

        rvLista.adapter = EnderecoAdapter(enderecos)
        rvLista.layoutManager = LinearLayoutManager(this)


        val fabClose = findViewById<FloatingActionButton>(R.id.fab_close)


        fabClose.setOnClickListener() {
            finish()
        }
    }
}
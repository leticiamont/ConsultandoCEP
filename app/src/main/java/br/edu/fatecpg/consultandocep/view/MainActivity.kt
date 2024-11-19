package br.edu.fatecpg.consultandocep.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.consultandocep.R
import br.edu.fatecpg.consultandocep.dao.EnderecoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enderecoDao = EnderecoDao()
        val edtCEP = findViewById<EditText>(R.id.edt_CEP)
        val btnSave = findViewById<Button>(R.id.btn_consulta)
        val fabTrans = findViewById<FloatingActionButton>(R.id.fab_ceps)

        btnSave.setOnClickListener(){
            if(edtCEP.text.toString() == ""){
                Toast.makeText(this, "Campo em branco!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(edtCEP.length() < 8){
                Toast.makeText(this, "Digite um o CEP correto!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            enderecoDao.BuscaEndereco(this, edtCEP.text.toString())

            edtCEP.text.clear()
        }



        fabTrans.setOnClickListener(){
            val ceps = Intent(this,EnderecoActivity::class.java)
            startActivity(ceps)
        }

    }
}
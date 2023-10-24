package com.example.examen
// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val agendaList = ArrayList<Agenda>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonAdd.setOnClickListener {
            val nombre = binding.editTextName.text.toString()
            val noControl = binding.editTextControl.text.toString()

            if (nombre.isNotBlank() && noControl.isNotBlank()) {
                val contacto = Agenda(nombre, noControl)
                agendaList.add(contacto)
                updateContactCount()
            }
        }

        binding.buttonViewAgenda.setOnClickListener {
            if (agendaList.isNotEmpty()) {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putParcelableArrayListExtra("contactList", agendaList)
                startActivity(intent)
            }
        }

        binding.buttonSearch.setOnClickListener {
            val searchControl = binding.editTextSearchControl.text.toString()
            if (searchControl.isNotBlank()) {
                val contact = agendaList.find { it.noControl == searchControl }
                if (contact != null) {
                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putParcelableArrayListExtra("contactList", arrayListOf(contact))
                    startActivity(intent)
                }
            }
        }
    }

    private fun updateContactCount() {
        val contactCount = agendaList.size
        binding.textViewContactCount.text = "Contactos: $contactCount"
    }
}

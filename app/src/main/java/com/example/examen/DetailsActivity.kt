package com.example.examen
// DetailsActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Obtén la lista de contactos desde el Intent
        val contactList = intent.getParcelableArrayListExtra<Agenda>("contactList")

        // Verifica si la lista no es nula
        if (contactList != null) {
            // Itera a través de la lista y muestra los contactos
            val contactDetails = StringBuilder()
            for (contact in contactList) {
                contactDetails.append("Nombre: ${contact.nombre}, No. Control: ${contact.noControl}\n")
            }

            // Muestra los detalles en el TextView
            binding.textViewContactName.text = contactDetails.toString()
        }

        binding.buttonBackToMain.setOnClickListener {
            finish()
        }
    }
}

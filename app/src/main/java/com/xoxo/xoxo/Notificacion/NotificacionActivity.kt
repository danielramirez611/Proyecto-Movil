package com.xoxo.xoxo.Notificacion

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xoxo.xoxo.Inicio.InicioActivity
import com.xoxo.xoxo.Inicio.NotificacionAdapter
import com.xoxo.xoxo.R

class NotificacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notificacion)

        val recyclerNotas = findViewById<RecyclerView>(R.id.recyclerNotificacion)

        val listNotas = listOf(
            Notificacion("¡Hola Auria! En este día te ofrecemos nuestro nuevo producto, hecho a base de cacao natural con ingredientes de calidad, para realzar tu belleza."),
            Notificacion("¡Hola Auria! En este día te ofrecemos nuestro nuevo producto, hecho a base de cacao natural con ingredientes de calidad, para realzar tu belleza."),
            Notificacion("¡Hola Auria! En este día te ofrecemos nuestro nuevo producto, hecho a base de cacao natural con ingredientes de calidad, para realzar tu belleza.")



            )

        val adapter = NotificacionAdapter(listNotas)
        recyclerNotas.adapter = adapter
        recyclerNotas.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //recyclerNotas.layoutManager=GridLayoutManager(this,2)


        val arrowIcon = findViewById<ImageView>(R.id.arrowIcon)
        // Configura el OnClickListener para el arrowIcon
        arrowIcon.setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
        }
    }
}
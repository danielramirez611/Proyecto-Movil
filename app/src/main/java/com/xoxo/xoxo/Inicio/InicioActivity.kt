package com.xoxo.xoxo.Inicio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xoxo.xoxo.Coleccion.ColeccionActivity
import com.xoxo.xoxo.Comprar.ComprarActivity
import com.xoxo.xoxo.Favorito.FavoritoActivity
import com.xoxo.xoxo.Notificacion.NotificacionActivity
import com.xoxo.xoxo.R
import com.xoxo.xoxo.RegisterActivity

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        val btnNoti = findViewById<ImageView>(R.id.btnNoti)
        btnNoti.setOnClickListener {
            startActivity(Intent(this, NotificacionActivity::class.java))


        }
        val recyclerInicio = findViewById<RecyclerView>(R.id.recyclerInicio)

        val listNotas = listOf(
            Inicio("Daniel Ramirez", "Producto A", "S/15", "Descuento 1","https://i.pinimg.com/236x/27/c3/82/27c382526ee33d00060315a96d96e057.jpg"),
            Inicio("Martin Kong", "Producto B", "S/20", "Descuento 2","https://xoxoskincarebr.com/cdn/shop/files/TAMANHOS_3.png?v=1699550727"),
            Inicio("Franco Huancas", "Producto C", "S/25", "Descuento 3","https://xoxoskincarebr.com/cdn/shop/files/TAMANHOS_5_4fcd4657-4529-42e1-933b-f80504ea1796.png?v=1702008060&width=533")
        )

        val adapter = InicioAdapter(listNotas)
        recyclerInicio.adapter = adapter
        recyclerInicio.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Configurar el padding para ajustar las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar la visibilidad del sistema UI
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        // Configurar el listener para la BottomNavigationView
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.firstFragment -> {
                loadActivity(InicioActivity::class.java)
                true
            }
            R.id.secondFragment -> {
                loadActivity(FavoritoActivity::class.java)
                true
            }
            R.id.thirdFragment -> {
                loadActivity(RegisterActivity::class.java)
                true
            }
            R.id.fourFragment -> {
                loadActivity(ColeccionActivity::class.java)
                true
            }
            R.id.fiveFragment -> {
                loadActivity(ComprarActivity::class.java)
                true
            }
            else -> false
        }
    }

    private fun loadActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
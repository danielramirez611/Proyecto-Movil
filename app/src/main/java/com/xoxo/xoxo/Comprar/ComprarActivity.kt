package com.xoxo.xoxo.Comprar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xoxo.xoxo.Coleccion.ColeccionActivity
import com.xoxo.xoxo.Favorito.FavoritoActivity
import com.xoxo.xoxo.Inicio.InicioActivity
import com.xoxo.xoxo.R
import com.xoxo.xoxo.RegisterActivity

class ComprarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comprar)
        val recyclerComprar = findViewById<RecyclerView>(R.id.recyclerComprar)

        val listComprar = listOf(
            Comprar("slime", "fresa", "S/12", "S/15"),
            Comprar("slime", "fresa", "S/12", "S/15"),
            Comprar("slime", "fresa", "S/12", "S/15"),
            Comprar("slime", "fresa", "S/12", "S/15"),
            Comprar("slime", "fresa", "S/12", "S/15")
        )

        val adapter = ComprarAdapter(listComprar)
        recyclerComprar.adapter = adapter
        recyclerComprar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

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

        // Marcar manualmente el botón correspondiente al fragmento de colecciones
        val menu = navigation.menu
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            if (item.itemId == R.id.fiveFragment) {
                item.isChecked = true
                break
            }
        }
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

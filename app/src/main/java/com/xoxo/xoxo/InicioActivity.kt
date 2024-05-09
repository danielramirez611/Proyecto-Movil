package com.xoxo.xoxo

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.graphics.drawable.Drawable
import android.widget.ImageButton
import androidx.core.content.ContextCompat


class InicioActivity : AppCompatActivity() {
    private var isLiked1 = false
    private var isLiked2 = false
    private var isLiked3 = false

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        val fabHeart1: FloatingActionButton = findViewById(R.id.fabHeart)
        val fabHeart2: FloatingActionButton = findViewById(R.id.fabHeart2)
        val fabHeart3: FloatingActionButton = findViewById(R.id.fabHeart3)

        // Define el OnClickListener común para ambos botones flotantes
        val onClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.fabHeart -> {
                    isLiked1 = !isLiked1
                    updateFabImage(view as FloatingActionButton, isLiked1)
                }
                R.id.fabHeart2 -> {
                    isLiked2 = !isLiked2
                    updateFabImage(view as FloatingActionButton, isLiked2)
                }
                R.id.fabHeart3 -> {
                    isLiked3 = !isLiked3
                    updateFabImage(view as FloatingActionButton, isLiked3)
                }
            }
        }

        // Asigna el OnClickListener a ambos botones flotantes
        fabHeart1.setOnClickListener(onClickListener)
        fabHeart2.setOnClickListener(onClickListener)
        fabHeart3.setOnClickListener(onClickListener)

        val imageProducto1 = findViewById<ImageView>(R.id.imageProducto1)
        imageProducto1.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("categoria", "Smile")
            intent.putExtra("nproducto", "Algodon Dulce")
            intent.putExtra("descripcion", "Nuestra Crema Hidratante Intensiva ofrece hidratación suprema y combate el envejecimiento prematuro, con una fórmula rica en antioxidantes y textura sedosa.")
            intent.putExtra("precio", "S/12")
            intent.putExtra("descuento", "S/15")

            startActivity(intent)
        }

        val imageProducto2 = findViewById<ImageView>(R.id.imageProducto2)
        imageProducto2.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("categoria", "Smile")
            intent.putExtra("nproducto", "Algodon Dulce")
            intent.putExtra("descripcion", "Nuestra Crema Hidratante Intensiva ofrece hidratación suprema y combate el envejecimiento prematuro, con una fórmula rica en antioxidantes y textura sedosa.")
            intent.putExtra("precio", "S/14")
            intent.putExtra("descuento", "S/16")

            startActivity(intent)
        }

        val imageProducto3 = findViewById<ImageView>(R.id.imageProducto3)
        imageProducto3.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("categoria", "Smile")
            intent.putExtra("nproducto", "CUPCAKE DE VAINILLA")
            intent.putExtra("descripcion", "Todos nuestros productos están hechos a mano. Por lo tanto, espere que cada artículo tenga un color y/o patrón de sombra diferente y único al que se muestra en la imagen.")
            intent.putExtra("precio", "S/20")
            intent.putExtra("descuento", "S/15")

            startActivity(intent)
        }

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
                loadActivity(CrearActivity::class.java)
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

    // Función para cambiar la imagen y aplicar el filtro de color al botón flotante
    private fun updateFabImage(fab: FloatingActionButton, isLiked: Boolean) {
        val imageResource = if (isLiked) {
            R.drawable.heart_red
        } else {
            R.drawable.heart
        }
        fab.setImageResource(imageResource)

        if (isLiked) {
            fab.setColorFilter(ContextCompat.getColor(this, R.color.rojo), android.graphics.PorterDuff.Mode.SRC_IN)
        } else {
            fab.clearColorFilter()
        }
    }
}

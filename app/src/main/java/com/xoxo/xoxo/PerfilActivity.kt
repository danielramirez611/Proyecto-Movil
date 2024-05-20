package com.xoxo.xoxo

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream

class PerfilActivity : AppCompatActivity() {

    lateinit var logoImageView: ImageView
    lateinit var sharedPref: SharedPreferences

    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }

    private lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        logoImageView = findViewById(R.id.logoImageView)
        sharedPref = getSharedPreferences("myPrefs", MODE_PRIVATE)

        val encodedImage = sharedPref.getString("encodedImage", null)
        if (encodedImage != null) {
            val imageBytes = Base64.decode(encodedImage, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            logoImageView.setImageBitmap(decodedImage)
        }

        // Initialize the photo picker launcher
        pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, it)
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
                val encodedImage = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
                with(sharedPref.edit()) {
                    putString("encodedImage", encodedImage)
                    apply()
                }
                logoImageView.setImageBitmap(bitmap)
            }
        }

        // Set the click listener for the ImageView
        logoImageView.setOnClickListener {
            if (PickVisualMedia.isPhotoPickerAvailable()) {
                pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
            } else {
                // Fallback to the older method if photo picker is not available
                val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(pickIntent, PICK_IMAGE_REQUEST)
            }
        }

        // Configurar el ImageView para que la imagen se muestre redonda
        logoImageView.clipToOutline = true
        logoImageView.scaleType = ImageView.ScaleType.CENTER_CROP
    }
}

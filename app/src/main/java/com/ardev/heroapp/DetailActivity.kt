package com.ardev.heroapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName = findViewById<TextView>(R.id.tv_prolangName)
        val tvDesc = findViewById<TextView>(R.id.tv_prolangDesc)
        val ivPhoto= findViewById<ImageView>(R.id.iv_pictures)

        val dataProLang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<ProgrammingLanguage>("PROLANG_DATA", ProgrammingLanguage::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<ProgrammingLanguage>("PROLANG_DATA")
        }

        tvName.text = dataProLang?.languageName
        tvDesc.text = dataProLang?.description
        ivPhoto.setImageResource(dataProLang?.photo!!)
    }
}
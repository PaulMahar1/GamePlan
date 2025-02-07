package com.example.gameplan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.Html
import android.widget.TextView


class TandC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tand_c)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val proceedButton = findViewById<ImageButton>(R.id.button)
        val cancelButton = findViewById<Button>(R.id.button2)

        val termsTextView: TextView = findViewById(R.id.your_textview_id)


        val terms = resources.getString(R.string.Terms)


        termsTextView.text = Html.fromHtml(terms, Html.FROM_HTML_MODE_LEGACY)


        proceedButton.setOnClickListener {
            proceedButton.setImageResource(R.drawable.hover1)
            val intent = Intent(this, HomeSkeleton::class.java)
            startActivity(intent)

            Handler(Looper.getMainLooper()).postDelayed({
                proceedButton.setImageResource(R.drawable.default1)
            }, 500)
        }

        cancelButton.setOnClickListener {
            finishAffinity()
        }



    }
}
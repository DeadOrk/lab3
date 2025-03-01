package com.example.lab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.calculateButton).setOnClickListener()
        {
            val input = findViewById<EditText>(R.id.inputText).text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Введите текст!", Toast.LENGTH_SHORT).show()
            }

            var charCount = 0
            for (char in input) {
                if (!char.toString().matches(Regex("[a-zA-Z]")))
                {
                    if (char.isLetter()) {
                        charCount++
                    }
                }
            }
            findViewById<TextView>(R.id.resultTextView).text =
                "Найдено: $charCount букв"
        }
    }
}
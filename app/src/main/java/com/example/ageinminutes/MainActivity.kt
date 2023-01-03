package com.example.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener{
            Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        }
    }
}
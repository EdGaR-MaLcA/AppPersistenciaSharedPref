package com.example.android.apppersistenciasharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = SharedPreferences(this)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val etName = findViewById<TextView>(R.id.etName)
        val btnRetrive = findViewById<Button>(R.id.btnRetrieve)
        val tvRetrieve = findViewById<TextView>(R.id.tvRetrive)

        btnSave.setOnClickListener {
            val name = etName.text.toString()

            sharedPreferences.save("name", name)

            Toast.makeText(this, "Data stored", Toast.LENGTH_LONG).show()
        }
        btnRetrive.setOnClickListener {
            if(sharedPreferences.getValue("name") != null){
                    tvRetrieve.setText(sharedPreferences.getValue("name"))
                }
        }
    }
}
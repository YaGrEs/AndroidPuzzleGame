package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Congratulations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)

        val ct = getIntent().getLongExtra("Remaining", 0)
        val IV: ImageView = findViewById(R.id.Happy)
        val end: Button = findViewById(R.id.OK)
        IV.setImageResource(getResources().getIdentifier("happy", "drawable", getPackageName()));
        val msg: TextView = findViewById(R.id.Result)
        msg.setText("YOU ARE WINNER. YOU COMPLETED THIS TASK IN " + (27000 - ct) / 1000 + "SECONDS")

        end.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
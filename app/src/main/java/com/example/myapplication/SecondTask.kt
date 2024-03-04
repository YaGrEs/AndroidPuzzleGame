package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class SecondTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)


        val ct = getIntent().getLongExtra("Remaining", 0)
        var timeleft = 1L
        val time: TextView = findViewById(R.id.timer2)
        val timer = object: CountDownTimer(ct, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeleft = millisUntilFinished
                time.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }
            override fun onFinish() {end()}
        }
        timer.start()

        val layout = findViewById<RelativeLayout>(R.id.points)
        val Text : EditText = findViewById(R.id.Enter)
        val count = Random.nextInt(3, 15)
        val xy = listOf(0F, 50F, 100F, 150F, 200F, 250F, 300F, 350F, 400F, 450F)
        for(i in 1..count){
            val IV = ImageView(this)
            IV.layoutParams= LinearLayout.LayoutParams(100, 100)
            IV.x= xy[Random.nextInt(0, 10)]
            IV.y= xy[Random.nextInt(0, 10)]
            IV.setImageDrawable(circle(Color.BLACK, 20F))
            layout?.addView(IV)
        }
        var answer: Button = findViewById(R.id.answer)
        answer.setOnClickListener {
            if (Text.text.toString().trim() == count.toString() ) {
                val intent = Intent(this, ThirdTask::class.java)
                intent.putExtra("Remaining", timeleft)
                timer.cancel()
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "It's not correct", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                timer.cancel()
                startActivity(intent)
                finish()
            }
        }
    }
    private fun end() {
        Toast.makeText(this, "Time is over", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
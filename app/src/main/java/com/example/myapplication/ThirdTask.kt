package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class ThirdTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_task)

        val ct = getIntent().getLongExtra("Remaining", 0)
        val lb: Button = findViewById(R.id.Lbutton)
        val rb: Button = findViewById(R.id.Bbutton)
        val time: TextView = findViewById(R.id.timer3)
        val layout1 = findViewById<RelativeLayout>(R.id.Fpointscreen)
        val layout2 = findViewById<RelativeLayout>(R.id.Spointscreen)
        val count1 = Random.nextInt(3, 15)
        val count2 = Random.nextInt(3, 15)
        val xy = listOf(0F, 50F, 100F, 150F, 200F, 250F, 300F, 350F, 400F, 450F)
        for(i in 1..count1){
            val IV = ImageView(this)
            IV.layoutParams= LinearLayout.LayoutParams(100, 100)
            IV.x= xy[Random.nextInt(0, 10)]
            IV.y= xy[Random.nextInt(0, 10)]
            IV.setImageDrawable(circle(Color.BLACK, 20F))
            layout1?.addView(IV)
        }
        for(i in 1..count2){
            val IV = ImageView(this)
            IV.layoutParams= LinearLayout.LayoutParams(100, 100)
            IV.x= xy[Random.nextInt(0, 10)]
            IV.y= xy[Random.nextInt(0, 10)]
            IV.setImageDrawable(circle(Color.BLACK, 20F))
            layout2?.addView(IV)
        }

        var timeleft = 1L
        val timer = object: CountDownTimer(ct, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeleft = millisUntilFinished
                time.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }
            override fun onFinish() {end()}
        }
        timer.start()

        lb.setOnClickListener {
            if (count1 > count2){
                val intent = Intent(this, Congratulations::class.java)
                timer.cancel()
                intent.putExtra("Remaining", timeleft)
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
        rb.setOnClickListener {
            if (count1 < count2){
                val intent = Intent(this, Congratulations::class.java)
                timer.cancel()
                intent.putExtra("Remaining", timeleft)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "It's not correct", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, First_task::class.java)
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
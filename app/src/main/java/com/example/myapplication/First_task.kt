package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import android.os.CountDownTimer

class First_task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)

        val colors = listOf(Color.RED, Color.GREEN, Color.BLACK, Color.GRAY, Color.YELLOW, Color.BLUE, Color.MAGENTA)
        val textcolors = listOf("Red", "Green", "Black", "Gray", "Yellow", "Blue", "Magenta")

        val time: TextView = findViewById(R.id.timer1)
        val first = Random.nextInt(0,7)
        val second = Random.nextInt(0, 7)
        var variants = listOf(first, second)
        var third = Random.nextInt(0,2)
        var fourth = Random.nextInt(0,2)
        val cr: ImageView = findViewById(R.id.Shape)
        cr.setImageDrawable(circle(colors.get(first), 100F))
        var cr2: ImageView = findViewById(R.id.Shape22)
        cr2.setImageDrawable(circle(colors.get(second), 100F))
        var ftext: TextView = findViewById(R.id.fcolor)
        var stext: TextView = findViewById(R.id.scolor)
        ftext.setTextColor(colors.get(variants.get(third)))
        stext.setTextColor(colors.get(variants.get(1 - third)))
        ftext.setText(textcolors.get(variants.get(fourth)))
        stext.setText(textcolors.get(variants.get(1 - fourth)))
        val yb: Button = findViewById(R.id.Yes)
        val nb: Button = findViewById(R.id.No)
        var timeleft = 1L

        val timer = object: CountDownTimer(27000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeleft = millisUntilFinished
                time.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }
            override fun onFinish() {end()}
        }
        timer.start()

        yb.setOnClickListener {
            if (first == variants.get(fourth)) {
                val intent = Intent(this, SecondTask::class.java)
                intent.putExtra("Remaining", timeleft)
                timer.cancel()
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "It's not correct", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                timer.cancel()
                startActivity(intent)
                finish()
            }
        }
        nb.setOnClickListener {
            if (first == variants.get(fourth)) {
                Toast.makeText(this, "It's not correct", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                timer.cancel()
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, SecondTask::class.java)
                intent.putExtra("Remaining", timeleft)
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

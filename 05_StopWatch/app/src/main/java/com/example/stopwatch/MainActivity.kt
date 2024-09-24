package com.example.stopwatch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var btn_start : Button
    private lateinit var btn_restart : Button
    private lateinit var tv_minute : TextView
    private lateinit var tv_second : TextView
    private lateinit var tv_millisecond : TextView

    private var isRunning = false

    private var timer : Timer? = null
    private var time = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_start = findViewById(R.id.button_start)
        btn_restart = findViewById(R.id.button_restart)
        tv_minute = findViewById(R.id.tv_minute)
        tv_second = findViewById(R.id.tv_second)
        tv_millisecond = findViewById(R.id.tv_millisecond)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.button_start -> {
                if (isRunning) {
                    pause()
                } else {
                    start()
                }
            }

            R.id.button_restart -> {
                restart()
            }
        }
    }

    private fun start() {
        btn_start.text = getString(R.string.btn_pause)
        btn_start.setBackgroundColor(getColor(R.color.btn_pause))
        isRunning = true

        timer = timer(period = 10) {
            // 1000ms = 1s
            // 0.01 time 1+
            time++

            // 3개의 텍스트 안에 값을 어떻게 넣어 줄지
            val milli_second = time % 100
            val second = (time % 6000) / 100
            val minute = time / 6000

            tv_millisecond.text = if(milli_second < 10) ".0${milli_second}" else ".${milli_second}"
            tv_second.text = if (second < 10) ":0${second}" else ":${second}"
            tv_minute.text = "${minute}"
        }
    }

    private fun pause() {

    }

    private fun restart() {

    }
}
package com.example.activityandfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TwoColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two_color)

        settingButtons()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun settingButtons() {
        val button_red = findViewById<Button>(R.id.button_red_fragment)
        val button_blue = findViewById<Button>(R.id.button_blue_fragment)

        // 여기 두 부분은 자세히 보기!
        button_red.setOnClickListener { // * 매우 중요! *
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,RedFragment())
            fragmentTransaction.commit()
        }

        button_blue.setOnClickListener { // * 매우 중요! *
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,BlueFragment())
            fragmentTransaction.commit()
        }
    }
}
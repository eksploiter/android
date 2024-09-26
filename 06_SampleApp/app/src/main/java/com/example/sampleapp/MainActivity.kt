package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth // firebase 인증 페이지에서 가져오기

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val joinBtnClicked = findViewById<Button>(R.id.joinBtn)
        joinBtnClicked.setOnClickListener {

            auth.createUserWithEmailAndPassword("abc@abc.com", "12341234")
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}
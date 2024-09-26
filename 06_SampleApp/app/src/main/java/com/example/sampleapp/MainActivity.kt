package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.sampleapp.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth // firebase 인증 페이지에서 가져오기

    // 두번째 방법 - 데이터 바인딩
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 현재 유저의 uid 값을 가져와라
        Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()

        // 두번째 방법 - 데이터 바인딩
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 첫번째 방법
        val joinBtnClicked = findViewById<Button>(R.id.joinBtn)
        joinBtnClicked.setOnClickListener {

            // 첫번째 방법
//            val email = findViewById<EditText>(R.id.emailArea)
//            val pwd = findViewById<EditText>(R.id.pwdArea)

            // 두번째 방법
            // 바인딩을 하게되면 첫번째 방법처럼 findViewById를 번거롭게 할 필요 없이 바로 사용할 수 있다.
            val email = binding.emailArea
            val pwd = binding.pwdArea

            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                    }
                }

        }

        // 로그아웃도 데이터 바인딩 이용
        binding.logoutBtn.setOnClickListener {

            auth.signOut()
            Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()
            // 로그아웃 버튼을 누르게 되면 null 이라는 토스트 메시지를 띄우고
            // 그 다음에는 uid 를 띄울 수 없게 한다.
        }

        // 로그인 역시 데이터 바인딩 이용
        binding.loginBtn.setOnClickListener {

            val email = binding.emailArea
            val pwd = binding.pwdArea

            auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                        Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }
}
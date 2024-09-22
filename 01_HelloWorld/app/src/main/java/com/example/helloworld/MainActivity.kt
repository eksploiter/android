package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// MainActivity -> AppCompatActivity -> Activity
class MainActivity : AppCompatActivity() { // MainActivity Class 는 AppCompatActivity()를 상속 받는다.
    // Activity = screen
    // AppCompatActivity = 기존 Activity Class + 호환성 기능

    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate() 는 Activity 가 실행될 때 처음 실행 되는 함수 입니다. (생명 주기)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setContentView 를 통해 MainActivity 에 layout 을 지정해 줄 수 있다.
    }
}

// 참고로 주석은 ctrl + / 누르면 된다. (아니면 평소 처럼 //)
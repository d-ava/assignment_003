package com.example.assignment_003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment_003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding
    val data = mutableListOf<UserData>(

        UserData("John", "Connor", "astalavista@baby.com" )

    )




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
package com.example.assignment_003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding
    val data = mutableListOf<UserData>(

        UserData("John", "Connor", "astalavista@baby.com" ),
                UserData("John", "Travolta", "john@travolta.com" )

    )

    private val adapter = UserAdapter(data)
    private val layoutManager = LinearLayoutManager(this)





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }








}
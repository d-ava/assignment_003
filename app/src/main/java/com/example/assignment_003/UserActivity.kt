package com.example.assignment_003

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_003.databinding.UserItemBinding

class UserActivity :AppCompatActivity(){

    lateinit var binding: UserItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserItemBinding.inflate(layoutInflater)
    }




    companion object {
        const val USER2 = "222"

    }

}
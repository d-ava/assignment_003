package com.example.assignment_003

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
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

        val editProfileLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val userData2 =
                        result.data?.getParcelableExtra<UserData>(UserActivity.USER2)


                    //


                }
            }



    }




    companion object {
        const val USER1 = "111"

    }





}
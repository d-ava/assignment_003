package com.example.assignment_003

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserAdapter.OnUserClickListener{


    lateinit var binding: ActivityMainBinding
    private val data = mutableListOf<UserData>(

        UserData("John", "Connor", "astalavista@baby.com"),
        UserData("John", "Travolta", "john@travolta.com"),
        UserData("Roger", "Waters", "mail1@mail.com"),
        UserData("Indiana", "jones", "mail2@mail.com"),
        UserData("Sir", "nickolson", "mail3@mail.com"),
        UserData("john", "lee", "mail4@mail.com"),
        UserData("bondo", "cage", "mail5@mail.com"),
        UserData("london", "rogers", "mail6@mail.com"),
    )

    private val adapter = UserAdapter(data, this)
    private val layoutManager = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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

    override fun onUserClick(position: Int) {

       val clickedUser: UserData = data[position]
        Toast.makeText(this, "# $position name is ${clickedUser.name}  ", Toast.LENGTH_LONG).show()
        // blabla
    }


    companion object {
        const val USER1 = "111"

    }


}
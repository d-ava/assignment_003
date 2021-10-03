package com.example.assignment_003

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserAdapter.OnUserClickListener {


    lateinit var binding: ActivityMainBinding
    private val dataList = mutableListOf<UserData>(

        UserData("John", "Connor", "astalavista@baby.com"),
        UserData("John", "Travolta", "john@travolta.com"),
        UserData("Roger", "Waters", "no@mail.com"),

        )

    private val adapter = UserAdapter(dataList, this)

    private val layoutManager = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter




        binding.btnAdd.setOnClickListener {
            onAddButtonClick()
        }

        val editProfileLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val userData2 =
                        result.data?.getParcelableExtra<UserData>(UserActivity.USER2)


                    //


                }
            }


    }


    override fun onEraseClick(btnErase: View, position: Int) {
        btnErase.setOnClickListener {
            //dataList.removeAt(position)

            dataList.removeAt(position)
            adapter.notifyItemRemoved(position)
            //Toast.makeText(this, "erase button clicked", Toast.LENGTH_SHORT).show()


        }


    }

    override fun onUpdateClick(btnUpdate: View) {
        btnUpdate.setOnClickListener {
            Toast.makeText(this, "Update button clicked", Toast.LENGTH_SHORT).show()

        }
    }


    companion object {
        const val USER1 = "111"

    }

    private fun onAddButtonClick() {
        val name = binding.eTAddName.text.toString()
        val lastName = binding.eTAddLastName.text.toString()
        val email = binding.eTAddEmail.text.toString()
        val addedUser = UserData(name, lastName, email)

        dataList.add(addedUser)
        adapter.notifyDataSetChanged()
    }


}
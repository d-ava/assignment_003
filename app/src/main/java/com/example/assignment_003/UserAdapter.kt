package com.example.assignment_003

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_003.databinding.UserItemBinding

class UserAdapter(private val dataSet:
                  MutableList<UserData>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    // Create new views (invoked by the layout manager)

    class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): UserViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = UserItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)


        return UserViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {

        val userItem = dataSet[position]
        viewHolder.binding.tvName.text = userItem.name
       viewHolder.binding.tvLastName.text = userItem.lastName
        viewHolder.binding.email.text = userItem.email

        viewHolder.binding.root.setOnClickListener {

        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

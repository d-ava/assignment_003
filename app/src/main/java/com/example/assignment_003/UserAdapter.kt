package com.example.assignment_003

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_003.databinding.UserItemBinding

class UserAdapter(
    private val dataSet: MutableList<UserData>,
    private val listener: OnUserClickListener
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    // Create new views (invoked by the layout manager)
    //class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    inner class UserViewHolder(val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onUserClick(position)
            }
        }
    }


    interface OnUserClickListener {
        fun onUserClick(position: Int)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): UserViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding =
            UserItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)


        return UserViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {

        val userItem = dataSet[position]
        viewHolder.binding.tvName.text = userItem.name
        viewHolder.binding.tvLastName.text = userItem.lastName
        viewHolder.binding.email.text = userItem.email




    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

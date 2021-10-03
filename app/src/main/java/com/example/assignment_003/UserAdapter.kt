package com.example.assignment_003

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            val btnErase = binding.btnErase
            val btnUpdate = binding.btnUpdate
            if (position != RecyclerView.NO_POSITION) {
                listener.onEraseClick(btnErase)
                listener.onUpdateClick(btnUpdate)

            }
        }
    }


    interface OnUserClickListener {
        //fun onUserClick(position: Int)
        fun onEraseClick(btnErase: View)
        fun onUpdateClick(btnUpdate : View)


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

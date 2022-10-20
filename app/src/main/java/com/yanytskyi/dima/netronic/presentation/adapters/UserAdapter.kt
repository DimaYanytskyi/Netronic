package com.yanytskyi.dima.netronic.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yanytskyi.dima.netronic.R
import com.yanytskyi.dima.netronic.domain.model.User

class UserAdapter(
    private val data: List<User>,
    private val onClick: (User) -> Unit
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val userThumbnail: ImageView = itemView.findViewById(R.id.user_thumbnail)
        val userName: TextView = itemView.findViewById(R.id.user_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userData = data[position]
        Glide.with(holder.itemView.context)
            .load(userData.thumbnailUrl)
            .into(holder.userThumbnail)
        holder.userName.text = userData.firstName
        holder.itemView.setOnClickListener {
            onClick(userData)
        }
    }

    override fun getItemCount(): Int = data.size
}
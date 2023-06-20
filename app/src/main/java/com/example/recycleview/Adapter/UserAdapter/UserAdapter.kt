package com.example.recycleview.Adapter.UserAdapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.User
import com.example.recycleview.databinding.ItemRvrBinding
import java.lang.NullPointerException

class UserAdapter(val list: List<User>,val context:Context,val rvAction: RvAction):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(val itemRvBinding:ItemRvrBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User,position: Int){
            itemRvBinding.nameRv.text = user.name
            itemRvBinding.numberRv.text = user.number

            val animation = AnimationUtils.loadAnimation(context, R.anim.animation)
            itemRvBinding.root.startAnimation(animation)

            itemRvBinding.root.setOnLongClickListener {
                rvAction.deleteUser(user,position)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvrBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position],position)
    }
    interface RvAction{
        fun deleteUser(user: User,position: Int)
    }


}
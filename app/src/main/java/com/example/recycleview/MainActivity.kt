package com.example.recycleview

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import com.example.recycleview.Adapter.UserAdapter.UserAdapter
import com.example.recycleview.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserAdapter
    lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        adapter = UserAdapter(list,this,object :UserAdapter.RvAction{
            override fun deleteUser(user: User, position: Int) {
                list.removeAt(position)
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position,list.size-1)
                Toast.makeText(this@MainActivity, "O'chirildi❌", Toast.LENGTH_SHORT).show()
            }
        })
        binding.rv.adapter = adapter
        binding.btnAdd.setOnClickListener {

            val user = User(binding.editText.text.toString(),binding.number.text.toString())
            list.add(user)
            Toast.makeText(this, "Saqlandi⬇️", Toast.LENGTH_SHORT).show()
            adapter.notifyItemChanged(list.size-1)
        }

    }

    private fun loadData() {
        list = ArrayList()

    }
}
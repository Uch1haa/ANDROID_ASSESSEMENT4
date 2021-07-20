package com.uche.userapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uche.userapp.activity.StudentAddActivity
import com.uche.userapp.databinding.ActivityMainBinding
import com.uche.userapp.ui.MainViewModel
import com.uche.userapp.ui.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, StudentAddActivity::class.java)
            startActivity(intent)
        }

        userAdapter = UserAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recycle.adapter = userAdapter

        viewModel.getItem()
            viewModel.itemLiveData.observe(this@MainActivity, {
                item ->
                userAdapter.item = item
                userAdapter.notifyDataSetChanged()
            })
        }



}
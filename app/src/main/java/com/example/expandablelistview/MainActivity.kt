package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expandablelistview.adapter.MyExpandAdapter
import com.example.expandablelistview.databinding.ActivityMainBinding
import com.example.expandablelistview.utils.MyData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myExpandAdapter: MyExpandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyData.addElement()

        myExpandAdapter = MyExpandAdapter(MyData.titleList, MyData.map)
        binding.myExpend.setAdapter(myExpandAdapter)

        binding.myExpend.setOnChildClickListener { expandableListView, view, i, i2, l ->
            Toast.makeText(this, "${MyData.map[MyData.titleList[i]]?.get(i2)}", Toast.LENGTH_SHORT).show()
            true
        }
    }
}
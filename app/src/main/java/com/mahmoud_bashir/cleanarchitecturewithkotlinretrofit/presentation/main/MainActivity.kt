package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val viewModel:MainViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPosts()
        viewModel.postsList.observe(this){ result ->

            if (result.data != null){

                Toast.makeText(applicationContext,"title: ${result.data!![0].title}",Toast.LENGTH_LONG).show()
                Log.d(TAG,"Data_size : ${result.data!!.size}")
               // viewModel.postsList.removeObservers(this)
            } else
                Log.d(TAG,"Data_size : ${result.message}")
        }
    }
}
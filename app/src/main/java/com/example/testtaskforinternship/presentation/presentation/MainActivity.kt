package com.example.testtaskforinternship.presentation.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskforinternship.R
import com.example.testtaskforinternship.presentation.presentation.VM.MainViewModel
import com.example.testtaskforinternship.presentation.presentation.VM.MainViewModelFactory
import com.example.testtaskforinternship.presentation.presentation.fragment.SayHelloFragment


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var sayHello: TextView
    private val SAY_HELLO = "say_hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)
        sayHello = findViewById(R.id.hello)
    }

    fun sayHello(view: View) {
        val sayHelloFragment = SayHelloFragment()
        val bundle = Bundle()
        bundle.putString(SAY_HELLO, mainViewModel.sayHello());
        sayHelloFragment.arguments = bundle
        sayHelloFragment.show(supportFragmentManager, SAY_HELLO)
    }

}
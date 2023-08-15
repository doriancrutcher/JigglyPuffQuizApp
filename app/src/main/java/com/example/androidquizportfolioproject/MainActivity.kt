package com.example.androidquizportfolioproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var enterButton:Button?=null
    var enterText:EditText?=null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterButton=findViewById(R.id.enterButton)
        enterText=findViewById(R.id.enterInput)


        enterButton?.setOnClickListener { hitSubmit() }

    }


    fun hitSubmit(){

        val userInput=enterText?.text.toString()

        if(userInput.isEmpty()){
            Toast.makeText(this,"please enter a user name",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Hello ${enterText?.text}",Toast.LENGTH_SHORT).show()

            val intent=Intent(this@MainActivity,QuizView::class.java)
            startActivity(intent)
        }
    }



}
package com.example.androidquizportfolioproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    var scoreMessage:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        scoreMessage=findViewById(R.id.scoreMessage)

        val receivedScore=intent.getIntExtra("totalAnswers",0)

        scoreMessage?.setText("Puff! You got a score of ${receivedScore.toString()}/4")


    }

    fun closeApp(){
        System.exit(0)
    }




}
package com.example.androidquizportfolioproject

data class QuestionClass (
    val id: Int,
    val question: String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)
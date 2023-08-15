package com.example.androidquizportfolioproject

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

public class QuizView : AppCompatActivity(), OnClickListener {

    var questionTitle: TextView? = null
    var imageView: ImageView? = null
    var answerOne: TextView? = null
    var answerTwo: TextView? = null
    var answerThree: TextView? = null
    var answerFour: TextView? = null
    var submitButton: Button? = null
    var progressBarQuiz: ProgressBar? = null
    var progressText: TextView? = null
    var currentQuestion: Int = 0
    var currentAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_view)

        questionTitle = findViewById(R.id.questionTitle)
        imageView = findViewById(R.id.imageView)
        answerOne = findViewById(R.id.answerOne)
        answerTwo = findViewById(R.id.answerTwo)
        answerThree = findViewById(R.id.answerThree)
        answerFour = findViewById(R.id.answerFour)
        submitButton = findViewById(R.id.submitButton)
        progressBarQuiz = findViewById(R.id.progressBarQuiz)
        progressText = findViewById(R.id.progressText)


        answerOne?.setOnClickListener(this)
        answerTwo?.setOnClickListener(this)
        answerThree?.setOnClickListener(this)
        answerFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)


        // Now you can call the function to set the question
        setQuestion(currentQuestion)
        defaultOptionsView()
    }


    private fun setQuestion(questionNumber: Int) {
        submitButton?.setText("Submit")

        val getQuestions = questionObjects.getQuestions()
        val currentQuestion = getQuestions[questionNumber]

        // Set question title
        questionTitle?.text = currentQuestion.question

        // Set image (assuming you have an ImageView and the 'image' field in your QuestionClass holds a drawable resource ID)
        imageView?.setImageResource(currentQuestion.image)

        // Set answer choices
        answerOne?.text = currentQuestion.optionOne
        answerTwo?.text = currentQuestion.optionTwo
        answerThree?.text = currentQuestion.optionThree
        answerFour?.text = currentQuestion.optionFour

        // Set Progress Bar

        progressBarQuiz?.progress = currentQuestion.id
        progressText?.setText("${currentQuestion.id}/${getQuestions.size}")

        // Set answer number
        currentAnswer = currentQuestion.correctAnswer


    }

    fun defaultOptionsView() {
        val optionsArray = ArrayList<TextView>()

        answerOne?.let {
            optionsArray.add(it)
        }

        answerTwo?.let {
            optionsArray.add(it)
        }

        answerThree?.let {
            optionsArray.add(it)
        }

        answerFour?.let {
            optionsArray.add(it)
        }

        for (option in optionsArray) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_answer_view
            )
        }
    }

    fun selectedOptionsView(optionVal: TextView?, selectedOptionNum: Int) {
        defaultOptionsView()

        optionVal?.background = ContextCompat.getDrawable(this, R.drawable.selected_answers_view)
    }


    fun onSubmit() {
        submitButton?.setText("Next")

        when (currentAnswer) {
            1 -> answerOne?.background = ContextCompat.getDrawable(this, R.drawable.correct_answer)
            2 -> answerTwo?.background = ContextCompat.getDrawable(this, R.drawable.correct_answer)
            3 -> answerThree?.background =
                ContextCompat.getDrawable(this, R.drawable.correct_answer)

            4 -> answerFour?.background = ContextCompat.getDrawable(this, R.drawable.correct_answer)
        }


    }

    fun onNext() {
        currentQuestion += 1
        defaultOptionsView()
        setQuestion(currentQuestion)
    }


    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.answerOne -> {
                selectedOptionsView(answerOne, 1)
                onSubmit()
            }

            R.id.answerTwo -> {
                selectedOptionsView(answerTwo, 2)
                onSubmit()
            }

            R.id.answerThree -> {
                selectedOptionsView(answerThree, 3)
                onSubmit()
            }

            R.id.answerFour -> {
                selectedOptionsView(answerFour, 4)
                onSubmit()
            }

            R.id.submitButton -> {
                onNext()
            }
        }
    }


}
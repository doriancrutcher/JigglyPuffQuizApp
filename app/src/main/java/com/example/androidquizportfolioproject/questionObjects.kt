package com.example.androidquizportfolioproject

object questionObjects{
    fun getQuestions() : MutableList<QuestionClass>{
        var questionList= mutableListOf<QuestionClass>()
        val Q1 = QuestionClass(
            id = 1,
            question = "What type of animal is this?",
            image = R.drawable.jigglypuff,
            optionOne = "Pikachu",
            optionTwo = "Rattata",
            optionThree = "Squirtle",
            optionFour = "Jigglypuff",
            correctAnswer = 4
        )

        questionList.add(Q1)

        val Q2 = QuestionClass(
            id = 2,
            question = "Which of these moves is commonly associated with Jigglypuff in the Pokémon games?",
            image = R.drawable.jigglypuff,
            optionOne = "Thunderbolt",
            optionTwo = "Sing",
            optionThree = "Hydro Pump",
            optionFour = "Earthquake",
            correctAnswer = 2
        )
        questionList.add(Q2)

        val Q3 = QuestionClass(
            id = 3,
            question = "In the Pokémon anime, what happens when Jigglypuff sings?",
            image = R.drawable.jigglypuff,
            optionOne = "It rains",
            optionTwo = "Everyone dances",
            optionThree = "Everyone falls asleep",
            optionFour = "Jigglypuff evolves",
            correctAnswer = 3
        )

        questionList.add(Q3)


        val Q4 = QuestionClass(
            id = 4,
            question = "What color is Jigglypuff?",
            image = R.drawable.jigglypuff,
            optionOne = "Green",
            optionTwo = "Yellow",
            optionThree = "Red",
            optionFour = "Pink",
            correctAnswer = 4
        )
        questionList.add(Q4)

        return questionList

    }

}
package com.valentinerutto.survey.data.model.local

data class  Answers(
    val question: String = "",
    val answer: String = ""
)
data class SurveyResponse(
    val id: String = "",
    val answers: List<Answers> = listOf()
)

enum class QuestionType{
    FREE_TEXT, SELECT_ONE,TYPE_VALUE
}

enum class AnswerType {
    SINGLE_LINE_TEXT, INTEGER
}
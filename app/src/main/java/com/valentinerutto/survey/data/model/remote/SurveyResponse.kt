package com.valentinerutto.survey.data.model.remote


import com.google.gson.annotations.SerializedName

data class SurveyResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("questions")
    val questions: List<Question?>?,
    @SerializedName("start_question_id")
    val startQuestionId: String?,
    @SerializedName("strings")
    val strings: Strings?
) {
    data class Question(
        @SerializedName("answer_type")
        val answerType: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("next")
        val next: String?,
        @SerializedName("options")
        val options: List<Option?>?,
        @SerializedName("question_text")
        val questionText: String?,
        @SerializedName("question_type")
        val questionType: String?
    ) {
        data class Option(
            @SerializedName("display_text")
            val displayText: String?,
            @SerializedName("value")
            val value: String?
        )
    }

    data class Strings(
        @SerializedName("en")
        val en: En?
    ) {
        data class En(
            @SerializedName("opt_female")
            val optFemale: String?,
            @SerializedName("opt_male")
            val optMale: String?,
            @SerializedName("opt_other")
            val optOther: String?,
            @SerializedName("q_farmer_gender")
            val qFarmerGender: String?,
            @SerializedName("q_farmer_name")
            val qFarmerName: String?,
            @SerializedName("q_size_of_farm")
            val qSizeOfFarm: String?
        )
    }
}
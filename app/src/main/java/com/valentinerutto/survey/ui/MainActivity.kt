package com.valentinerutto.survey.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import com.google.gson.Gson
import com.valentinerutto.survey.data.SubmitSurveyWorker
import com.valentinerutto.survey.data.model.local.QuestionType
import com.valentinerutto.survey.data.model.remote.SurveyResponse
import com.valentinerutto.survey.databinding.ActivityMainBinding
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity(), StepperFormListener {

    private val surveyViewModel  by viewModel<SurveyViewModel>()
    private lateinit var binding: ActivityMainBinding

    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    override fun onStart() {
        super.onStart()
        surveyViewModel.fetchSaveSurvey()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            val survey = surveyViewModel.getSurvey()

            survey.map {

                when(it.questionType?.let { it1 -> QuestionType.valueOf(it1) }){

                    QuestionType.FREE_TEXT ->{
                        binding.layoutFarmSize.visibility = View.INVISIBLE
                        binding.layoutGender.visibility = View.INVISIBLE
                        binding.layoutName.visibility = View.VISIBLE
                        binding.txtName.text = it.questionText

                    }

                    QuestionType.SELECT_ONE ->{
                        binding.layoutName.visibility = View.INVISIBLE
                        binding.layoutFarmSize.visibility = View.INVISIBLE
                        binding.layoutGender.visibility = View.VISIBLE
                    }

                    QuestionType.TYPE_VALUE ->{
                        binding.layoutName.visibility = View.INVISIBLE
                       binding.layoutFarmSize.visibility = View.VISIBLE
                        binding.layoutGender.visibility = View.INVISIBLE

                    }

                }
            }

        }

        setUpOnClickListener()
    }

   private fun setUpOnClickListener(){

        binding.btnNextName.setOnClickListener{


        }
    }

    private fun createSubmitSurveyWorker(answeredSurveys: List<SurveyResponse>) {
        val imageWorker = PeriodicWorkRequestBuilder<SubmitSurveyWorker>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .addTag("submitSurveyWork")
            .setInputData(workDataOf("survey" to Gson().toJson(answeredSurveys)))
            .build()
        workManager.enqueueUniquePeriodicWork(
            "periodicSubmitSurvey",
            ExistingPeriodicWorkPolicy.KEEP,
            imageWorker
        )

    }

    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

    override fun onCompletedForm() {
        TODO("Not yet implemented")
    }

    override fun onCancelledForm() {
        TODO("Not yet implemented")
    }

}
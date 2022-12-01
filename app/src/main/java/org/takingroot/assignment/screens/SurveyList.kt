package org.takingroot.assignment.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import org.takingroot.assignment.models.Survey
import org.takingroot.assignment.viewmodels.SurveyViewModel

@Composable
fun SurveyList(viewModel: SurveyViewModel) {
    fun createSamples() {
        val surveys = (0..5).map {
            Survey(
                name = "Survey $it"
            )
        }
        viewModel.save(surveys = surveys.toTypedArray())
    }

    val surveys: List<Survey>? by viewModel.surveys.observeAsState()

    Column {
        Text(text = "Surveys")
        Column {
            println("Surveys" + viewModel.surveys.value)
            surveys?.forEach {
                Text(text = "Survey ${it.name}")
            }
        }
        Row {
            Button(onClick = viewModel::refresh) {
                Text(text = "Refresh")
            }
            Button(onClick = { createSamples() }) {
                Text(text = "Create samples")
            }
        }
    }
}
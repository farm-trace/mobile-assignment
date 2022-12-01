package org.takingroot.assignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.takingroot.assignment.models.AppDatabase
import org.takingroot.assignment.models.Survey
import org.takingroot.assignment.repositories.ISurveyRepository
import org.takingroot.assignment.repositories.SurveyRepository

class SurveyViewModel(private val repository: ISurveyRepository) : ViewModel() {
    val surveys = repository.surveys

    init {
        this.refresh()
    }

    fun send(vararg surveys: Survey) = viewModelScope.launch(Dispatchers.IO) {
        withContext(this.coroutineContext) {
            repository.delete(*surveys)
            repository.fetchAll()
        }
    }

    fun save(vararg surveys: Survey) = viewModelScope.launch(Dispatchers.IO) {
        withContext(this.coroutineContext) {
            repository.save(
                *surveys
            )
        }
        refresh()
    }

    fun refresh() = viewModelScope.launch(Dispatchers.IO) {
        withContext(this.coroutineContext) { repository.fetchAll() }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                val db = AppDatabase.getDatabase(application)
                val repository = SurveyRepository(db.surveyDao())
                return SurveyViewModel(repository) as T
            }
        }
    }
}
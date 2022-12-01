package org.takingroot.assignment.repositories

import androidx.lifecycle.MutableLiveData
import org.takingroot.assignment.models.Survey
import org.takingroot.assignment.models.SurveyDao

interface ISurveyRepository {
    var surveys: MutableLiveData<List<Survey>>
    suspend fun save(vararg survey: Survey)
    suspend fun fetchAll()
}

class SurveyRepository(private val surveyDao: SurveyDao) : ISurveyRepository {
    override var surveys: MutableLiveData<List<Survey>> = MutableLiveData()

    override suspend fun save(vararg survey: Survey) {
        surveyDao.save(*survey)
    }

    override suspend fun fetchAll() {
        println("Refreshing")
        surveys.postValue(surveyDao.getAll())
        println("Refreshed")
    }

}
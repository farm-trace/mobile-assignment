package org.takingroot.assignment.models

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Entity(tableName = "surveys")
data class Survey(
    @PrimaryKey
    @NonNull
    var id: UUID = UUID.randomUUID(),

    @NonNull
    var name: String = ""
)

@Dao
interface SurveyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(vararg survey: Survey)

    @Query("select * from surveys")
    suspend fun getAll(): List<Survey>
}
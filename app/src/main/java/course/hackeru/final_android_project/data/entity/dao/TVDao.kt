package course.hackeru.final_android_project.data.entity.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import course.hackeru.final_android_project.data.entity.TV

//Queries, actions in front of the API
@Dao
interface TVDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(tvs: List<TV>)

    @Query("SELECT * FROM TV")
    fun getTvs(): LiveData<List<TV>>
}
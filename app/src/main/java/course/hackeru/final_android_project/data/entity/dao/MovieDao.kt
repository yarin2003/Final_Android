package course.hackeru.final_android_project.data.entity.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import course.hackeru.final_android_project.data.entity.Movie

//Queries, actions in front of the API
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(movies: List<Movie>)

    @Query("SELECT * FROM Movie")
    fun getMovies(): LiveData<List<Movie>>
}
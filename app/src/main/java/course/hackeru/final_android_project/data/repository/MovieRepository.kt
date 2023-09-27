package course.hackeru.final_android_project.data.repository

import android.util.Log
import course.hackeru.final_android_project.data.entity.dao.MovieDao
import course.hackeru.final_android_project.data.mapper.toMovie
import course.hackeru.final_android_project.data.service.ApiService
import course.hackeru.final_android_project.data.service.dto.movies.MovieDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MovieDao, private val apiService: ApiService){

    //get movies from local db
    fun getMovies() = movieDao.getMovies()

    //refresh -> query from the api that saves to the db
    suspend fun refreshMovies(){
       withContext(Dispatchers.IO){
           val movies = apiService.getMovies().movies
           //TODO: Delete log
           Log.d("api movies", "refreshMovies:${movies} ")
           movieDao.addAll(movies.map ( MovieDTO::toMovie))
       }
    }
}
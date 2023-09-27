package course.hackeru.final_android_project.data.service

import course.hackeru.final_android_project.data.service.dto.movies.MovieResponse
import course.hackeru.final_android_project.data.service.dto.tvs.TVResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie")
    suspend fun getMovies(): MovieResponse

    @GET("tv")
    suspend fun getTVs(): TVResponse
}

//   https://api.themoviedb.org/3/discover/movie?api_key=53ccf1e48ec4b003aeb8129b0cf28d49

// https://api.themoviedb.org/3/discover/movie?api_key=53ccf1e48ec4b003aeb8129b0cf28d49




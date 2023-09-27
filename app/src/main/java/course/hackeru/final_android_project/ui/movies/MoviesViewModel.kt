package course.hackeru.final_android_project.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import course.hackeru.final_android_project.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repo: MovieRepository) : ViewModel(){

    val movies  = repo.getMovies()

    init {
        viewModelScope.launch {
            //TODO: Delete log
            Log.d("movies database", ":${movies.value}")


            //get Movies from API
            repo.refreshMovies()
        }
    }
}
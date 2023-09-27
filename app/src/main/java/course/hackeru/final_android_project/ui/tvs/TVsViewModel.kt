package course.hackeru.final_android_project.ui.tvs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import course.hackeru.final_android_project.data.repository.TVRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVsViewModel @Inject constructor(private val repo: TVRepository) : ViewModel() {

    val tvs = repo.getTVs()

    init {
        viewModelScope.launch {
            //get TVs from API
            repo.refreshTVs()
        }
    }
}





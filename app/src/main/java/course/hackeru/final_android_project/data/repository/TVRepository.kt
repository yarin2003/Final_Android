package course.hackeru.final_android_project.data.repository

import course.hackeru.final_android_project.data.entity.dao.TVDao
import course.hackeru.final_android_project.data.mapper.toTV
import course.hackeru.final_android_project.data.service.ApiService
import course.hackeru.final_android_project.data.service.dto.tvs.TVDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TVRepository @Inject constructor(private val tvDao: TVDao, private val apiService: ApiService){

    //get tvs from tvs db
    fun getTVs() = tvDao.getTvs()

    //refresh -> query from api that saves to the db
    suspend fun refreshTVs(){
        withContext(Dispatchers.IO) {
            val tvs = apiService.getTVs().tvs
            tvDao.addAll(tvs.map (TVDTO::toTV))
        }
    }
}
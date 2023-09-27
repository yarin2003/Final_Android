package course.hackeru.final_android_project.data.service.dto.tvs


import com.google.gson.annotations.SerializedName

data class TVResponse(
    val page: Int,
    @SerializedName("results")
    val tvs: List<TVDTO>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
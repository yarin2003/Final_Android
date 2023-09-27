package course.hackeru.final_android_project.data.mapper

import course.hackeru.final_android_project.data.entity.TV
import course.hackeru.final_android_project.data.service.dto.tvs.TVDTO

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

//dto mapping
fun TVDTO.toTV() = TV(
    id = id,
    name = name,
    overview = overview,
    firstAirDate = firstAirDate,
    tvGenres = genreIds.mapNotNull { tvGenres[it] },
    originalLanguage = originalLanguage,
    posterUrl = "$IMAGE_BASE_URL$posterUrl"
)

private val tvGenres = mapOf(
    10759 to "Action & Adventure",
    16 to "Animation",
    35 to "Comedy",
    80 to "Crime",
    99 to "Documentary",
    18 to "Drama",
    10751 to "Family",
    10762 to "Kids",
    9648 to "Mystery",
    10763 to "News",
    10764 to "Reality",
    10765 to "Sci-Fi & Fantasy",
    10766 to "Soap",
    10767 to "Talk",
    10768 to "War & Politics",
    37 to "Western"
)
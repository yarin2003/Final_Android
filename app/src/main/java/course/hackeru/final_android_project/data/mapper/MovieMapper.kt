package course.hackeru.final_android_project.data.mapper

import course.hackeru.final_android_project.data.entity.Movie
import course.hackeru.final_android_project.data.service.dto.movies.MovieDTO

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

//dto mapping
fun MovieDTO.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    movieGenres = genreIds.mapNotNull { movieGenres[it] },
    originalLanguage = originalLanguage,
    releaseDate = releaseDate,
    posterUrl = "$IMAGE_BASE_URL$posterUrl"
)

private val movieGenres = mapOf(
    28 to "action",
    12 to "Adventure",
    16 to "Animation",
    35 to "Comedy",
    80 to "Crime",
    99 to "Documentary",
    18 to "Drama",
    10751 to "Family",
    14 to "Fantasy",
    36 to "History",
    27 to "Horror",
    10402 to "Music",
    9648 to "Mystery",
    10749 to "Romance",
    878 to "Science Fiction",
    10770 to "TV Movie",
    53 to "Thriller",
    10752 to "War",
    37 to "Western"
)
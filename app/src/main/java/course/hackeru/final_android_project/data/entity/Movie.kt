package course.hackeru.final_android_project.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//The form I'd like the data to be saved in the db.

@Entity
@Parcelize
data class Movie(
    val title: String,
    val overview: String,
    val movieGenres: List<String>,
    val originalLanguage: String,
    val releaseDate: String,
    val posterUrl: String,
    @PrimaryKey
    val id: Int?
):Parcelable

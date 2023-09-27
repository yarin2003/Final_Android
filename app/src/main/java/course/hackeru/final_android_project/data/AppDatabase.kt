package course.hackeru.final_android_project.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import course.hackeru.final_android_project.data.converters.Converter
import course.hackeru.final_android_project.data.entity.Movie
import course.hackeru.final_android_project.data.entity.TV
import course.hackeru.final_android_project.data.entity.dao.MovieDao
import course.hackeru.final_android_project.data.entity.dao.TVDao

private const val DB_VERSION = 2

@TypeConverters(Converter::class)
@Database(entities = [Movie::class, TV::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    //props:
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TVDao
}

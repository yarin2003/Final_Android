package course.hackeru.final_android_project.data.converters

import androidx.room.TypeConverter

fun <T> List<T>.toShortString() =
    joinToString(separator = ",") {"$it"}

//Convert the type of the genres List in order to save it in the db
class Converter {

    //A method which gets List of String and returns it as a String
    @TypeConverter
    fun genresToString(genresIds: List<String>): String{
        return genresIds.toShortString()
    }

    //A method which gets String and returns it as a List of String
    @TypeConverter
    fun stringToGenres(str: String): List<String>{
        return str.split(",")
    }
}
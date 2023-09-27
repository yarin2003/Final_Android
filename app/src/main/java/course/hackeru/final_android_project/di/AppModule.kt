package course.hackeru.final_android_project.di

import android.content.Context
import androidx.room.Room
import course.hackeru.final_android_project.data.AppDatabase
import course.hackeru.final_android_project.data.service.ApiService
import course.hackeru.final_android_project.data.service.utils.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL ="https://api.themoviedb.org/3/discover/"
private const val DB_NAME = "AppDB"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideTokenInterceptor(): TokenInterceptor = TokenInterceptor()

    @Provides
    fun provideHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideMovieDao(db: AppDatabase) = db.movieDao()

    @Provides
    fun provideTvDao(db: AppDatabase) = db.tvDao()

//    @Provides
//    fun provideMovieRepository(movieDao: MovieDao) = MovieRepository(movieDao)
//
//    @Provides
//    fun provideTvRepository(tvDao: TVDao) = TVRepository(tvDao)
}
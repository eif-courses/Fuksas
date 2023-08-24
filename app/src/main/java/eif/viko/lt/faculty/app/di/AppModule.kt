package eif.viko.lt.faculty.app.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.faculty.app.data.local.GroupDatabase
import eif.viko.lt.faculty.app.data.remote.TimetableApi
import eif.viko.lt.faculty.app.data.repositories.TimetableRepositoryImpl
import eif.viko.lt.faculty.app.domain.repositories.TimetableRepository
import eif.viko.lt.faculty.app.domain.use_cases.GetGroupsUseCase
import eif.viko.lt.faculty.app.domain.use_cases.TimetableUseCases
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTimetableApi(): TimetableApi {
        return Retrofit.Builder()
            .baseUrl(TimetableApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TimetableApi::class.java)
    }
    @Provides
    @Singleton
    fun provideTimetableRepository(
        api: TimetableApi,
        db: GroupDatabase
    ): TimetableRepository {
        return TimetableRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGroupDatabase(app: Application): GroupDatabase {
        return Room.databaseBuilder(
            app,
            GroupDatabase::class.java,
            "timetable_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTimetableUseCases(
        repository: TimetableRepository
    ): TimetableUseCases {
        return TimetableUseCases(getGroupsUseCase = GetGroupsUseCase(repository))
    }


}
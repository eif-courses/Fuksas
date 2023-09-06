package eif.viko.lt.faculty.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.faculty.app.data.local.GroupDatabase
import eif.viko.lt.faculty.app.data.remote.AuthApi
import eif.viko.lt.faculty.app.data.remote.ShopApi
import eif.viko.lt.faculty.app.data.remote.TimetableApi
import eif.viko.lt.faculty.app.data.repositories.AuthRepositoryImpl
import eif.viko.lt.faculty.app.data.repositories.TimetableRepositoryImpl
import eif.viko.lt.faculty.app.domain.repositories.AuthRepository
import eif.viko.lt.faculty.app.domain.repositories.TimetableRepository
import eif.viko.lt.faculty.app.domain.use_cases.GemsUseCases
import eif.viko.lt.faculty.app.domain.use_cases.GetGemsUseCase
import eif.viko.lt.faculty.app.domain.use_cases.GetGroupsUseCase
import eif.viko.lt.faculty.app.domain.use_cases.TimetableUseCases
import eif.viko.lt.faculty.app.domain.util.OAuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideOkHTTPClient(authInterceptor: OAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApi(retrofitBuilder: Retrofit.Builder): AuthApi {
        return retrofitBuilder
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShopApi(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): ShopApi {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
            .create(ShopApi::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(
        api: AuthApi,
        prefs: SharedPreferences
    ): AuthRepository {
        return AuthRepositoryImpl(api, prefs)
    }


    @Singleton
    @Provides
    fun provideTimetableApi(): TimetableApi {
        return Retrofit.Builder()
            .baseUrl(TimetableApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TimetableApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTimetableRepository(
        api: TimetableApi,
        db: GroupDatabase
    ): TimetableRepository {
        return TimetableRepositoryImpl(api, db.dao)
    }


    @Singleton
    @Provides
    fun provideGroupDatabase(app: Application): GroupDatabase {
        return Room.databaseBuilder(
            app,
            GroupDatabase::class.java,
            "db_timetable"
        ).build()
    }


    @Singleton
    @Provides
    fun provideTimetableUseCases(
        repository: TimetableRepository
    ): TimetableUseCases {
        return TimetableUseCases(getGroupsUseCase = GetGroupsUseCase(repository))
    }

}
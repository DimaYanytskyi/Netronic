package com.yanytskyi.dima.netronic.app.di

import android.content.Context
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.yanytskyi.dima.netronic.app.Constants.BASE_URL
import com.yanytskyi.dima.netronic.app.Constants.DATABASE_NAME
import com.yanytskyi.dima.netronic.data.api.UserProfileApi
import com.yanytskyi.dima.netronic.data.database.AppDatabase
import com.yanytskyi.dima.netronic.data.database.dao.UserProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserProfileApi(client: OkHttpClient) : UserProfileApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(UserProfileApi::class.java)
    }

    @Provides
    fun provideUserProfileDao(db: AppDatabase) : UserProfileDao {
        return db.profilesDao()
    }
}
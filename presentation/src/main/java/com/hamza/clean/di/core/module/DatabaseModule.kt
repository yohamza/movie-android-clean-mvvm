package com.hamza.clean.di.core.module

import android.content.Context
import androidx.room.Room
import com.hamza.data.db.favoritemovies.FavoriteMovieDao
import com.hamza.data.db.movies.MovieDao
import com.hamza.data.db.movies.MovieDatabase
import com.hamza.data.db.movies.MovieRemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ameer Hamza on 03/09/2023
 **/
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movie.db").build()
    }

    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    @Provides
    fun provideMovieRemoteKeyDao(movieDatabase: MovieDatabase): MovieRemoteKeyDao {
        return movieDatabase.movieRemoteKeysDao()
    }

    @Provides
    fun provideFavoriteMovieDao(movieDatabase: MovieDatabase): FavoriteMovieDao {
        return movieDatabase.favoriteMovieDao()
    }
}
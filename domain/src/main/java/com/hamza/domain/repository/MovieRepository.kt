package com.hamza.domain.repository

import androidx.paging.PagingData
import com.hamza.domain.entities.MovieEntity
import com.hamza.domain.util.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ameer Hamza on 03/09/2023
 */
interface MovieRepository {
    fun movies(pageSize: Int): Flow<PagingData<MovieEntity>>
    fun favoriteMovies(pageSize: Int): Flow<PagingData<MovieEntity>>
    fun search(query: String, pageSize: Int): Flow<PagingData<MovieEntity>>
    suspend fun getMovie(movieId: Int): Result<MovieEntity>
    suspend fun checkFavoriteStatus(movieId: Int): Result<Boolean>
    suspend fun addMovieToFavorite(movieId: Int)
    suspend fun removeMovieFromFavorite(movieId: Int)
}
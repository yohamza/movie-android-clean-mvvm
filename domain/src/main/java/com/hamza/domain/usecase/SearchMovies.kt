package com.hamza.domain.usecase

import androidx.paging.PagingData
import com.hamza.domain.entities.MovieEntity
import com.hamza.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author by Ameer Hamza on 03/09/2023
 */
class SearchMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String, pageSize: Int): Flow<PagingData<MovieEntity>> = movieRepository.search(query, pageSize)
}

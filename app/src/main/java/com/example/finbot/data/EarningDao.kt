package com.example.finbot.data

import androidx.room.*
import com.example.finbot.model.Earning
import kotlinx.coroutines.flow.Flow

@Dao
interface EarningDao {
    @Query("SELECT * FROM earnings ORDER BY date DESC")
    fun getAllEarnings(): Flow<List<Earning>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEarning(earning: Earning)

    @Update
    suspend fun updateEarning(earning: Earning)

    @Delete
    suspend fun deleteEarning(earning: Earning)

    @Query("SELECT * FROM earnings WHERE category = :category")
    fun getEarningsByCategory(category: String): Flow<List<Earning>>

    @Query("SELECT SUM(amount) FROM earnings WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalEarningsBetweenDates(startDate: String, endDate: String): Double
} 
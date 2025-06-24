package com.example.finbot.data

import androidx.room.*
import com.example.finbot.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Update
    suspend fun updateExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expenses WHERE category = :category")
    fun getExpensesByCategory(category: String): Flow<List<Expense>>

    @Query("SELECT SUM(CAST(amount AS REAL)) FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalExpensesBetweenDates(startDate: String, endDate: String): Double
} 
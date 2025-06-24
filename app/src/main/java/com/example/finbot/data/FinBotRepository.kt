package com.example.finbot.data

import com.example.finbot.model.Expense
import com.example.finbot.model.Earning
import kotlinx.coroutines.flow.Flow

class FinBotRepository(private val expenseDao: ExpenseDao, private val earningDao: EarningDao) {
    
    // Expense operations
    val allExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()
    
    suspend fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }
    
    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }
    
    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }
    
    fun getExpensesByCategory(category: String): Flow<List<Expense>> {
        return expenseDao.getExpensesByCategory(category)
    }
    
    suspend fun getTotalExpensesBetweenDates(startDate: String, endDate: String): Double {
        return expenseDao.getTotalExpensesBetweenDates(startDate, endDate)
    }
    
    // Earning operations
    val allEarnings: Flow<List<Earning>> = earningDao.getAllEarnings()
    
    suspend fun insertEarning(earning: Earning) {
        earningDao.insertEarning(earning)
    }
    
    suspend fun updateEarning(earning: Earning) {
        earningDao.updateEarning(earning)
    }
    
    suspend fun deleteEarning(earning: Earning) {
        earningDao.deleteEarning(earning)
    }
    
    fun getEarningsByCategory(category: String): Flow<List<Earning>> {
        return earningDao.getEarningsByCategory(category)
    }
    
    suspend fun getTotalEarningsBetweenDates(startDate: String, endDate: String): Double {
        return earningDao.getTotalEarningsBetweenDates(startDate, endDate)
    }
} 
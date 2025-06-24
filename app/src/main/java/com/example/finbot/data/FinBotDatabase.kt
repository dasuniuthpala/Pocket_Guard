package com.example.finbot.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finbot.model.Expense
import com.example.finbot.model.Earning

@Database(entities = [Expense::class, Earning::class], version = 1, exportSchema = false)
abstract class FinBotDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun earningDao(): EarningDao

    companion object {
        @Volatile
        private var INSTANCE: FinBotDatabase? = null

        fun getDatabase(context: Context): FinBotDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FinBotDatabase::class.java,
                    "finbot_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
} 
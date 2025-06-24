package com.example.finbot.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Data Persistence
@Entity(tableName = "expenses")
data class  Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val iconResId: Int,
    val name: String,
    val category: String,
    val date: String,
    val time: String,
    val amount: String,
    val categoryId: Int
)
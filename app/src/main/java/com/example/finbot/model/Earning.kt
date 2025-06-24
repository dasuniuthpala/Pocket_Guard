package com.example.finbot.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity Definitions
@Entity(tableName = "earnings")
data class Earning(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val category: String,
    val amount: Double,
    val date: String
)
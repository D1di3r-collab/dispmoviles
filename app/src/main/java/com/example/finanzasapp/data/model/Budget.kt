package com.example.finanzasapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "budgets")
data class Budget(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val userId: Long,
    val category: ExpenseCategory,
    val monthlyLimit: Double,

    val month: Int,
    val year: Int,

    val createAt: Long = System.currentTimeMillis()
)

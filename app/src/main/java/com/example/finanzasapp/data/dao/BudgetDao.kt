package com.example.finanzasapp.data.dao

import androidx.room.*
import com.example.finanzasapp.data.model.Budget
import com.example.finanzasapp.data.model.ExpenseCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(budget: Budget)

    @Query("SELECT * FROM budgets WHERE userId = :userId  AND month = :month AND year = :year")
    fun getBudgetsByMonthYear(userId: Long, month: Int, year: Int): Flow<List<Budget>>

    @Query("SELECT * FROM budgets WHERE category = :category  AND month = :month AND year = :year Limit 1")
    fun getBudgetByCategoryMonthYear(
        userId: Long,
        category: ExpenseCategory,
        month: Int,
        year: Int
    ): Flow<Budget?>

    @Update
    suspend fun update(budget: Budget)

    @Delete
    suspend fun delete(budget: Budget)


}
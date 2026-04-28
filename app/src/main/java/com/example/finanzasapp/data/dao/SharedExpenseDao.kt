package com.example.finanzasapp.data.dao

import androidx.room.*

import com.example.finanzasapp.data.model.SharedExpense
import kotlinx.coroutines.flow.Flow

interface SharedExpenseDao {

    @Query("SELECT * FROM shared_expenses WHERE creatorUserId = :creatorUserId ORDER BY date DESC")
    fun getSharedExpensesByUser(creatorUserId: Long): Flow<List<SharedExpense>>

    @Query("SELECT * FROM shared_expenses WHERE creatorUserId = :creatorUserId AND settled = 0")
    fun  getUnsettledSharedExpenses(creatorUserId: Long): Flow<List<SharedExpense>>

    @Update
    suspend fun update(sharedExpense: SharedExpense)

    @Delete
    suspend fun delete(sharedExpense: SharedExpense)


}
package com.example.finanzasapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.finanzasapp.data.dao.BudgetDao
import com.example.finanzasapp.data.dao.ExpenseDao
import com.example.finanzasapp.data.dao.UserDao
import com.example.finanzasapp.data.model.Budget
import com.example.finanzasapp.data.model.Expense
import com.example.finanzasapp.data.model.SharedExpense
import com.example.finanzasapp.data.model.User

@Database(
    entities = [User::class, Expense::class, Budget::class, SharedExpense::class],
    version = 1,
    exportSchema = false
)

@TypeConverters( Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun expenseDao() : ExpenseDao
    abstract fun budgetDao() : BudgetDao
    abstract fun sharedExpenseDao() : SharedExpense

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "finance_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
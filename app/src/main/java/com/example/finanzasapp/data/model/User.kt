package com.example.finanzasapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,
    val email: String,
    val passwordHash: String,

    val createAt: Long = System.currentTimeMillis()
)
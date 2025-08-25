package com.abitask.githubuserportfolio.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abitask.githubuserportfolio.data.local.dao.UserDao
import com.abitask.githubuserportfolio.data.local.dao.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
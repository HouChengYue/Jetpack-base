package com.hcy.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hcy.data.dao.BaseDao

/**
 * description :
 * @author HCY
 * @date 2021/4/10
 */
abstract class BaseDatabase : RoomDatabase() {
    abstract fun baseDao(): BaseDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDatabase? = null

        fun getDatabase(context: Context): BaseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatabase::class.java,
                    "base_datbase"
                ).build()
                instance
            }
        }

    }
}
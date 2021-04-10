package com.hcy.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hcy.data.bean.Base
import kotlinx.coroutines.flow.Flow

/**
 * description :
 * @author HCY
 * @date 2021/4/10
 */
@Dao
interface BaseDao {
    /**
     * 按照字母排序查询
     */
    @Query("SELECT * FROM base_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<Base>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pBase: Base)

    @Query("DELETE FROM base_table")
    suspend fun deleteAll()

}
package com.hcy.data.repository

import androidx.annotation.WorkerThread
import com.hcy.data.bean.Base
import com.hcy.data.dao.BaseDao
import kotlinx.coroutines.flow.Flow

/**
 * description :
 * @author HCY
 * @date 2021/4/12
 */
class BaseRepository(private val baseDao:BaseDao) {
    val  allBase:Flow<List<Base>> = baseDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(base:Base){
        baseDao.insert(base)
    }
}
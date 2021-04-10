package com.hcy.data.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * description :案例用类
 * @author HCY
 * @date 2021/4/10
 */
@Entity(tableName = "base_table")
class Base (@PrimaryKey(autoGenerate = true) @ColumnInfo val id:Int, @ColumnInfo val word:String)
package com.football.taiwo.football.Database.Tables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.football.taiwo.football.Database.Tables.TablesEntity

@Dao
interface TablesDao{
    @Query("SELECT * FROM tablesTable")
    fun allTables():List<TablesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tablesEntity: TablesEntity)
}
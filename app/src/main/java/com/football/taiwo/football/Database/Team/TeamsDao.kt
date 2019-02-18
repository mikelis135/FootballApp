package com.football.taiwo.football.Database.Team

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamsDao{
    @Query("SELECT * FROM teamsTable")
    fun allTeams():List<TeamsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamsEntity: TeamsEntity)
}
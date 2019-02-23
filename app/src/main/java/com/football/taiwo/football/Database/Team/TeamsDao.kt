package com.football.taiwo.football.Database.Team

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamsDao{
    @Query("SELECT * FROM teamsTable WHERE competition LIKE :competitionId order by id")
    fun allTeams(competitionId : Int):List<TeamsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamsEntity: TeamsEntity)
}
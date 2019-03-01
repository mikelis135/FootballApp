package com.football.taiwo.football.Database.TeamPlayer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamPlayersDao{
    @Query("SELECT * FROM teamPlayersTable WHERE team LIKE :teamId order by id")
    fun allTeams(teamId : Int):List<TeamPlayersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamPlayersEntity: TeamPlayersEntity)
}
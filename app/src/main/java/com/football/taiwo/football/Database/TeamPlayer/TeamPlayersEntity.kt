package com.football.taiwo.football.Database.TeamPlayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "teamPlayersTable")
data class TeamPlayersEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var tablesID: Int,

    @ColumnInfo(name = "teamname")
    var teamName: String,

    @ColumnInfo(name = "playername")
    var playerName: String,

    @ColumnInfo(name = "shirt")
    var playerShirt: String,

    @ColumnInfo(name = "position")
    var playerPosition: String,

    @ColumnInfo(name = "team")
    var team: Int,

    @ColumnInfo(name = "crestUrl")
    var crestUrl: String

) : Serializable
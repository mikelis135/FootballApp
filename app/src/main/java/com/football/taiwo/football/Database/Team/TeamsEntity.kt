package com.football.taiwo.football.Database.Team

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teamsTable")
data class TeamsEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var tablesID: Int,

    @ColumnInfo(name = "name")
    var teamName: String,

    @ColumnInfo(name = "crestUrl")
    var crestUrl: String

)
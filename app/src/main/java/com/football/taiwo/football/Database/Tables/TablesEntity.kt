package com.football.taiwo.football.Database.Tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablesTable")
data class TablesEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var tablesID: Int,

    @ColumnInfo(name = "count")
    var tablesCount: String,

    @ColumnInfo(name = "position")
    var tablesPosition: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "crestUrl")
    var crestUrl: String,

    @ColumnInfo(name = "playedGames")
    var playedGames: String,

    @ColumnInfo(name = "goalsFor")
    var goalsFor: String,

    @ColumnInfo(name = "points")
    var points: String





)
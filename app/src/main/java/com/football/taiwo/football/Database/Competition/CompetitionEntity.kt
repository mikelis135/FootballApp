package com.football.taiwo.football.Database.Competition

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "footballTable")
data class CompetitionEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var competitionID: Int,

    @ColumnInfo(name = "count")
    var competitionCount: Int,

    @ColumnInfo(name = "name")
    var competitionName: String
)
package com.football.taiwo.football.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.football.taiwo.football.Database.Competition.CompetitionDao
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureDao
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import com.football.taiwo.football.Database.Tables.TablesDao
import com.football.taiwo.football.Database.Tables.TablesEntity
import com.football.taiwo.football.Database.TeamPlayer.TeamPlayersDao
import com.football.taiwo.football.Database.TeamPlayer.TeamPlayersEntity
import com.football.taiwo.football.Database.Team.TeamsDao
import com.football.taiwo.football.Database.Team.TeamsEntity

@Database(entities = [CompetitionEntity::class, FixtureEntity::class, TablesEntity::class, TeamsEntity::class, TeamPlayersEntity::class], version = 2)

abstract class RoomSingleton : RoomDatabase() {
    abstract fun competitionDao(): CompetitionDao
    abstract fun fixtureDao(): FixtureDao
    abstract fun tablesDao() : TablesDao
    abstract fun teamsDao() : TeamsDao
    abstract fun teamPlayerDao() : TeamPlayersDao

    companion object {
        private var INSTANCE: RoomSingleton? = null
        fun getInstance(context: Context): RoomSingleton {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomSingleton::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as RoomSingleton
        }
    }
}
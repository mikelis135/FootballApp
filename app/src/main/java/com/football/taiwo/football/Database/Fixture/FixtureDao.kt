package com.football.taiwo.football.Database.Fixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.football.taiwo.football.Database.Fixture.FixtureEntity

@Dao
interface FixtureDao{
    @Query("SELECT * FROM fixtureTable")
    fun allFixtures():List<FixtureEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fixtureEntity: FixtureEntity)
}
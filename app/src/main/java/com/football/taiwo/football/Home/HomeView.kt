package com.football.taiwo.football.Home

import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity

interface HomeView {

    //the HomeView interfaces

    fun showShimmer()
    fun stopShimmer()
    fun setFixtureItems()
    fun setCompetitionItems()
    fun openCompetitionsPage(competitionID : Int, competitionName: String)
}
package com.football.taiwo.football.Home

import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity

interface HomeView {
    fun showShimmer()
    fun stopShimmer()
    fun setFixtureItems(items: FixtureEntity)
    fun setCompetitionItems(items: CompetitionEntity)
    fun openCompetitionsPage(competitionID : Int, competitionName: String)
}
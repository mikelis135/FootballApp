package com.football.taiwo.football.Competitions

import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Database.Tables.TablesEntity

interface CompetitionView {
    fun showShimmer()
    fun stopShimmer()
    fun setTable(items: MutableList<TablesEntity>)
    fun setTeams(items: MutableList<CompetitionTeamModel>)
    fun setFixture(items: MutableList<CompetitionFixtureModel>)
}
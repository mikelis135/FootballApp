package com.football.taiwo.football.Competitions.CompetitionTeam

import com.football.taiwo.football.Database.Team.TeamsEntity

interface CompetitionTeamView {
    fun showShimmer()
    fun stopShimmer()
    fun setTeams(competitionId: Int)
    fun openTeamPlayerPage(position : Int, items: MutableList<TeamsEntity>)
}
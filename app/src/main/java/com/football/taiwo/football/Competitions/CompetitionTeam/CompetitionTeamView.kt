package com.football.taiwo.football.Competitions.CompetitionTeam

interface CompetitionTeamView {
    fun showShimmer()
    fun stopShimmer()
    fun setTeams(items: MutableList<CompetitionTeamModel>)
    fun openTeamPlayerPage(position : Int, items: CompetitionTeamModel)
}
package com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer


interface TeamPlayerView {
    fun showShimmer()
    fun stopShimmer()
    fun setTeamPlayer(items: MutableList<TeamPlayerModel>)
}
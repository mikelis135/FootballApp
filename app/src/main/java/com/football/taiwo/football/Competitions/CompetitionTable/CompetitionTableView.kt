package com.football.taiwo.football.Competitions.CompetitionTable

import com.football.taiwo.football.Database.Competition.CompetitionEntity

interface CompetitionTableView {
    fun showShimmer()
    fun stopShimmer()
    fun setTable(competitionId : Int)
    fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>)
}
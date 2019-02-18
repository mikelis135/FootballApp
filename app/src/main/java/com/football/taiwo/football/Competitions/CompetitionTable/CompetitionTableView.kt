package com.football.taiwo.football.Competitions.CompetitionTable

import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Tables.TablesEntity

interface CompetitionTableView {
    fun showShimmer()
    fun stopShimmer()
    fun setTable(items: TablesEntity)
    fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>)
}
package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Competitions.CompetitionView
import com.football.taiwo.football.Database.Tables.TablesEntity

class CompetitionPresenter(var competitionView: CompetitionView, val competitionInteractor: CompetitionInteractor)  : CompetitionInteractor.handleEvents{

    fun loadTableCompetitions() {
      //  competitionInteractor.callTablecompetitions(::onCompetitionsTableLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    fun loadTeamCompetitions() {
        competitionInteractor.callTeamcompetitions(::onCompetitionsTeamLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    fun loadFixtureCompetitions() {
        competitionInteractor.callFixturecompetitions(::onCompetitionsFixtureLoaded)
        Log.d("okh", "loadingCompetitions")
    }


    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }


     private fun onCompetitionsTableLoaded(items: MutableList<TablesEntity>) {
        competitionView.apply {
            setTable(items)
        }
    }

    private fun onCompetitionsTeamLoaded(items: MutableList<CompetitionTeamModel>) {
        competitionView.apply {
            setTeams(items)
        }

    }

    private fun onCompetitionsFixtureLoaded(items: MutableList<CompetitionFixtureModel>) {
        competitionView.apply {
            setFixture(items)
        }
    }

}
package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureView
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Competitions.CompetitionView

class CompetitionFixturePresenter(var competitionView: CompetitionFixtureView, val competitionInteractor: CompetitionFixtureInteractor)  : CompetitionInteractor.handleEvents{

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

    private fun onCompetitionsFixtureLoaded(items: MutableList<CompetitionFixtureModel>) {
        competitionView.apply {
            setFixture(items)
        }
    }

    fun onCompetitionFixtureClicked(position: Int, item: MutableList<CompetitionFixtureModel>){
            Log.d("okh", item.get(position).teamName+" team click")
//         competitionView?.apply {
//           //  openCompetitionsPage(position, item.get(position).competitionTitle)
//         }
        }

}
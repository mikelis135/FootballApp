package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamView
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel

class CompetitionTeamPresenter(var competitionTeamView: CompetitionTeamView, val competitionInteractor: CompetitionTeamInteractor)  : CompetitionInteractor.handleEvents{

    fun loadTeamCompetitions() {
        competitionInteractor.callTeamcompetitions(::onCompetitionsTeamLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }

    private fun onCompetitionsTeamLoaded(items: MutableList<CompetitionTeamModel>) {
        competitionTeamView.apply {
            setTeams(items)
        }

    }

    fun onCompetitionTeamClicked(position: Int, item: MutableList<CompetitionTeamModel>){
            Log.d("okh", item.get(position).teamName+" team click")
         competitionTeamView.apply {
             openTeamPlayerPage(position, item.get(position))
         }
        }


}
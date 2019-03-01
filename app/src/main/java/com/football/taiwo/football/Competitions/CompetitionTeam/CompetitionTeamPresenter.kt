package com.football.taiwo.football.Competitions.CompetitionTeam

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionInteractor
import com.football.taiwo.football.Database.Team.TeamsEntity

class CompetitionTeamPresenter(var competitionTeamView: CompetitionTeamView, val competitionInteractor: CompetitionTeamInteractor)  : CompetitionInteractor.HandleEvents{

    fun loadTeamCompetitions(competitionId: Int) {
        competitionInteractor.callTeamcompetitions(competitionId,::onCompetitionsTeamLoaded)
        Log.d("okh", "loadingStandings")
    }

    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }

    private fun onCompetitionsTeamLoaded(competitionId : Int) {
        competitionTeamView.apply {
            setTeams(competitionId)
            Log.d("okh", "$competitionId presenter")
        }
    }


    fun onCompetitionTeamClicked(position: Int, item: MutableList<TeamsEntity>){
            Log.d("okh", item[position].teamName+" team click")
         competitionTeamView.apply {
             openTeamPlayerPage(position, item)
         }
        }


}
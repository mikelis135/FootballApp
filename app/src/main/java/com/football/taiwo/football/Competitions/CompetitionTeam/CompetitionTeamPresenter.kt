package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamView
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Database.Team.TeamsEntity

class CompetitionTeamPresenter(var competitionTeamView: CompetitionTeamView, val competitionInteractor: CompetitionTeamInteractor)  : CompetitionInteractor.handleEvents{

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
            Log.d("okh", competitionId.toString() + " presenter")
        }
    }


    fun onCompetitionTeamClicked(position: Int, item: MutableList<TeamsEntity>){
            Log.d("okh", item.get(position).teamName+" team click")
         competitionTeamView.apply {
             openTeamPlayerPage(position, item)
         }
        }


}
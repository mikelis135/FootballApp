package com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer

import android.util.Log
import com.football.taiwo.football.Database.TeamPlayer.TeamPlayersEntity
import com.football.taiwo.football.Competitions.CompetitionInteractor

class TeamPlayerPresenter(var teamPlayerView: TeamPlayerView, val teamPlayerInteractor: TeamPlayerInteractor)  :
    CompetitionInteractor.HandleEvents {

    fun loadTeamPlayer(teamId: Int) {
        teamPlayerInteractor.callTeamPlayer(teamId, ::onTeamPlayerLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }


   private fun onTeamPlayerLoaded(teamId : Int) {
       teamPlayerView.apply {
            setTeamPlayer(teamId)
        }
    }

    fun onTeamPlayerClicked(position: Int, item: MutableList<TeamPlayersEntity>){
            Log.d("okh", item[position].teamName+" team click")

        }

}
package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerView
import com.football.taiwo.football.Database.Team.TeamPlayersEntity

class TeamPlayerPresenter(var teamPlayerView: TeamPlayerView, val teamPlayerInteractor: TeamPlayerInteractor)  : CompetitionInteractor.handleEvents{

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
            Log.d("okh", item.get(position).teamName+" team click")
//         teamPlayerView?.apply {
//             //setTeamPlayer(item)
//           //  openCompetitionsPage(position, item.get(position).competitionTitle)
//         }
        }

}
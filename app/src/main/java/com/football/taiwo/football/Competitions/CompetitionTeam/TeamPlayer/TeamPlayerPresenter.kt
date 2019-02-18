package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerView
import com.football.taiwo.football.Competitions.CompetitionView

class TeamPlayerPresenter(var teamPlayerView: TeamPlayerView, val teamPlayerInteractor: TeamPlayerInteractor)  : CompetitionInteractor.handleEvents{

    fun loadTeamPlayer() {
        teamPlayerInteractor.callTeamPlayer(::onTeamPlayerLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }


   private fun onTeamPlayerLoaded(items: MutableList<TeamPlayerModel>) {
       teamPlayerView.apply {
            setTeamPlayer(items)
        }
    }

    fun onTeamPlayerClicked(position: Int, item: MutableList<TeamPlayerModel>){
            Log.d("okh", item.get(position).teamName+" team click")
//         teamPlayerView?.apply {
//             //setTeamPlayer(item)
//           //  openCompetitionsPage(position, item.get(position).competitionTitle)
//         }
        }

}
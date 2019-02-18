package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel

class TeamPlayerInteractor {

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTeamPlayer (callback : (MutableList<TeamPlayerModel>) -> Unit ) {
         callback(createTeamPlayerModel())
    }

    private fun createTeamPlayerModel(): MutableList<TeamPlayerModel>  {
        var teamPlayerModelList : MutableList<TeamPlayerModel> = ArrayList()
        var teamPlayerModel : TeamPlayerModel
        var players = mutableListOf<String>("David de Gae", "Phil Jones", "Paul Pogba", "Juan Mata")
        var playerRoles = mutableListOf<String>("Keeper", "Center-Back", "Central Midfield", "Attacking Midfield")
        var playerShirt = mutableListOf<String>("1", "3", "5", "7")

        for (i in 0 until players.size){
            teamPlayerModel = TeamPlayerModel(
                i,
                "url",
                "Manchester United", players, playerRoles, playerShirt

            )
            teamPlayerModelList.add(i,teamPlayerModel)
        }
        Log.d("okh", teamPlayerModelList.get(0).toString())
        return teamPlayerModelList
    }

}
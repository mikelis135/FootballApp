package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel

class CompetitionTeamInteractor {

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTeamcompetitions (callback : (MutableList<CompetitionTeamModel>) -> Unit ) {
        // callback(createCompetitionTeamModel())
    }

//    private fun createCompetitionTeamModel(): MutableList<CompetitionTeamModel>  {
//        var competitionTeamList : MutableList<CompetitionTeamModel> = ArrayList()
//        var competitionTeamModel : CompetitionTeamModel
//        var competitions = mutableListOf("Man City", "ManU", "Liverpool", "Spurs", "Man City", "ManU", "Liverpool", "Spurs","Man City", "ManU", "Liverpool", "Spurs")
//
//        for (i in 0..competitions.size-1){
//            competitionTeamModel = CompetitionTeamModel(
//                i,
//                "url",
//                competitions[i]
//            )
//            competitionTeamList.add(i,competitionTeamModel)
//        }
//        Log.d("okh", competitionTeamList.get(0).toString())
//        return competitionTeamList
//    }

}
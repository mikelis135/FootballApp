package com.football.taiwo.football.Home

import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel

class CompetitionFixtureInteractor {

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callFixturecompetitions (callback : (MutableList<CompetitionFixtureModel>) -> Unit ) {
        // callback(createCompetitionFixtureModel())
    }
//
//    private fun createCompetitionFixtureModel(): MutableList<CompetitionFixtureModel>  {
//        var competitionFixtureList : MutableList<CompetitionFixtureModel> = ArrayList()
//        var competitionFixtureModel : CompetitionFixtureModel
//        var competitions = mutableListOf("Man City", "ManU", "Liverpool", "Spurs", "Man City", "ManU", "Liverpool", "Spurs","Man City", "ManU", "Liverpool", "Spurs")
//
//        for (i in 0..competitions.size-1){
//            competitionFixtureModel = CompetitionFixtureModel(
//                i,
//                "url",
//                competitions[i]
//            )
//            competitionFixtureList.add(i,competitionFixtureModel)
//        }
//        Log.d("okh", competitionFixtureList.get(0).toString())
//        return competitionFixtureList
//    }

}
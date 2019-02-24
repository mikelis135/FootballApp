package com.football.taiwo.football.Competitions.CompetitionFixture

class CompetitionFixtureInteractor {

    interface HandleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callFixturecompetitions (callback : (MutableList<CompetitionFixtureModel>) -> Unit ) {

    }

}
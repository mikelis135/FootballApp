package com.football.taiwo.football.Competitions.CompetitionFixture

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionInteractor

class CompetitionFixturePresenter(var competitionView: CompetitionFixtureView, val competitionInteractor: CompetitionFixtureInteractor)  : CompetitionInteractor.HandleEvents{

    fun loadFixtureCompetitions() {
        competitionInteractor.callFixturecompetitions(::onCompetitionsFixtureLoaded)
        Log.d("okh", "loadingCompetitions")
    }


    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }

    private fun onCompetitionsFixtureLoaded(items: MutableList<CompetitionFixtureModel>) {
        competitionView.apply {
            setFixture(items)
        }
    }

    fun onCompetitionFixtureClicked(position: Int, item: MutableList<CompetitionFixtureModel>){
            Log.d("okh", item[position].teamName+" team click")

        }

}
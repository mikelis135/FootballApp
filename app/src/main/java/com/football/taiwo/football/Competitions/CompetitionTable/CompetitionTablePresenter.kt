package com.football.taiwo.football.Competitions.CompetitionTable

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionInteractor
import com.football.taiwo.football.Database.Tables.TablesEntity

class CompetitionTablePresenter(var competitionView: CompetitionTableView, val competitionInteractor: CompetitionTableInteractor)  : CompetitionInteractor.HandleEvents{

    fun loadTableCompetitions(competitionId: Int) {
        competitionInteractor.callTablecompetitions(competitionId,::onCompetitionsTableLoaded)
        Log.d("okh", "loadingStandings")
    }


    override fun oncompetitionClick() {

       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }


     private fun onCompetitionsTableLoaded(competitionId : Int) {
        competitionView.apply {
            setTable(competitionId)
            Log.d("okh", "$competitionId presenter")
        }
    }

     fun onCompetitionTableClicked(position: Int, item: MutableList<TablesEntity>){
            Log.d("okh", item[position].name+" team click")

        }

}
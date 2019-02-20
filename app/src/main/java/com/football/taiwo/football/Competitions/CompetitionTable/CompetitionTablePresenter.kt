package com.football.taiwo.football.Home

import android.util.Log
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableView
import com.football.taiwo.football.Database.Tables.TablesEntity

class CompetitionTablePresenter(var competitionView: CompetitionTableView, val competitionInteractor: CompetitionTableInteractor)  : CompetitionInteractor.handleEvents{

    fun loadTableCompetitions() {
        competitionInteractor.callTablecompetitions(::onCompetitionsTableLoaded)
        Log.d("okh", "loadingStandings")
    }

    override fun oncompetitionClick() {
       }

    override fun onLoadStart() {
     }

    override fun onLoadFinished() {
     }


     private fun onCompetitionsTableLoaded(items: TablesEntity) {
        competitionView.apply {
            setTable(items)
        }
    }

     fun onCompetitionTableClicked(position: Int, item: MutableList<TablesEntity>){
            Log.d("okh", item.get(position).name+" team click")
//         competitionView?.apply {
//           //  openCompetitionsPage(position, item.get(position).competitionTitle)
//         }
        }

}
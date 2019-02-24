package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Database.Tables.TablesEntity

class CompetitionInteractor : AppCompatActivity(){

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTablecompetitions (callback : (MutableList<TablesEntity>) -> Unit ) {
         callback(createCompetitionTableModel())
    }

    fun  callTeamcompetitions (callback : (MutableList<CompetitionTeamModel>) -> Unit ) {
       //  callback(createCompetitionTeamModel())
    }

    fun  callFixturecompetitions (callback : (MutableList<CompetitionFixtureModel>) -> Unit ) {
      //   callback(createCompetitionFixtureModel())
    }

     private fun createCompetitionTableModel(): MutableList<TablesEntity>  {
         var tablesList : MutableList<TablesEntity> = ArrayList()
//         doAsync {
//             val list = App.getInstance(applicationContext).tablesDao().allTables()
//             uiThread {
//                 for (football in 0 until list.size) {
//                     tablesList.add(football, list.get(football))
//                     // toast(list.get(football).fixtureAwayTeam)
//                     Log.d("okh", tablesList.toString()+" from table fragment")
//
//                 }
//
//             }
//         }
    return tablesList
}

    private fun createCompetitionTeamModel(): MutableList<CompetitionTeamModel>  {
        var competitionTeamList : MutableList<CompetitionTeamModel> = ArrayList()
        var competitionTeamModel : CompetitionTeamModel
        var competitions = mutableListOf("Man City", "ManU", "Liverpool", "Spurs", "Man City", "ManU", "Liverpool", "Spurs","Man City", "ManU", "Liverpool", "Spurs")

        for (i in 0..competitions.size-1){
            competitionTeamModel = CompetitionTeamModel(
                i,
                "url",
                competitions[i]
            )
            competitionTeamList.add(i,competitionTeamModel)
        }
        Log.d("okh", competitionTeamList.get(0).toString())
        return competitionTeamList
    }

//    private fun createCompetitionFixtureModel(): MutableList<CompetitionFixtureModel>  {
//        var tablesList : MutableList<TablesEntity> = ArrayList()
//        doAsync {
//            val list = App.getInstance(applicationContext).tablesDao().allTables()
//            uiThread {
//                for (football in 0 until list.size) {
//                    tablesList.add(football, list.get(football))
//                    // toast(list.get(football).fixtureAwayTeam)
//                    Log.d("okh", tablesList.toString()+" from table fragment")
//
//                }
//
//            }
//        }
//        return tablesList
//    }

}
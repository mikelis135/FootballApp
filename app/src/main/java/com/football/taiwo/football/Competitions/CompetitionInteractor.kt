package com.football.taiwo.football.Competitions

import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Database.Tables.TablesEntity

class CompetitionInteractor : AppCompatActivity(){

    interface HandleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTeamcompetitions (callback : (MutableList<CompetitionTeamModel>) -> Unit ) {

    }

    fun  callFixturecompetitions (callback : (MutableList<CompetitionFixtureModel>) -> Unit ) {

    }

     private fun createCompetitionTableModel(): MutableList<TablesEntity>  {

         return ArrayList()
}

}
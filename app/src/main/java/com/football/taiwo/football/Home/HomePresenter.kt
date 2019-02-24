package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import com.football.taiwo.football.Database.Tables.TablesEntity

class HomePresenter( var homeView : HomeView, val homeInteractor: HomeInteractor)  : AppCompatActivity() {

    fun loadFixtures() {
        homeInteractor.callFixtures(::onFixturesLoaded)
    }

    fun loadCompetitions() {
        homeInteractor.callCompetitions(::onCompetitionsLoaded)
    }

    private fun onFixturesLoaded(items: FixtureEntity) {
        homeView.apply {
            setFixtureItems(items)
        }
    }
     private fun onCompetitionsLoaded(items: CompetitionEntity) {
        homeView.apply {
            setCompetitionItems(items)

        }
    }


    fun onFixtureItemClicked(position: Int, item: MutableList<FixtureEntity>){
        homeView.apply {
            Log.d("okh", item[position].fixtureAwayTeam+ position)

        }
    }

     fun onCompetitionItemClicked(position: Int, item: MutableList<CompetitionEntity>){

         Log.d("okh", item[position].competitionID.toString()+" clickcomp")
         homeView.apply {

             openCompetitionsPage(item[position].competitionID, item[position].competitionName)

         }
        }

    fun onTableLoaded(position: Int, item: MutableList<TablesEntity>){

        Log.d("okh", item[position].name +" clickcomp")
        homeView.apply {
            openCompetitionsPage(item[position].tablesID, item[position].name)

        }
    }

}
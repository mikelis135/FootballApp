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
            Log.d("okh", item.get(position).fixtureAwayTeam+ position)

        }
    }

     fun onCompetitionItemClicked(position: Int, item: MutableList<CompetitionEntity>){
         //homeInteractor.createCompetitionTeamModel(item.get(position).competitionID)
         Log.d("okh", item.get(position).competitionID.toString()+" clickcomp")
         homeView.apply {
//             homeInteractor.createCompetitionTableModel(item.get(position).competitionID)
             openCompetitionsPage(item.get(position).competitionID, item.get(position).competitionName)

         }
        }

    fun onTableLoaded(position: Int, item: MutableList<TablesEntity>){
      //  homeInteractor.createCompetitionTableModel(item.get(position).tablesID)
        //homeInteractor.createCompetitionTeamModel(item.get(position).competitionID)
        Log.d("okh", item.get(position).name.toString()+" clickcomp")
        homeView.apply {
            openCompetitionsPage(item.get(position).tablesID, item.get(position).name)

        }
    }

}
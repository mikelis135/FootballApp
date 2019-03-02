package com.football.taiwo.football.Competitions.CompetitionTable

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Database.Tables.TablesEntity
import com.football.taiwo.football.Database.Team.TeamsEntity
import com.football.taiwo.football.Home.Apicalls
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import java.util.*

class CompetitionTableInteractor : AppCompatActivity() {

    interface HandleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTablecompetitions (competitionId : Int, callback : (Int) -> Unit ) {
        Log.d("okh", competitionId.toString() + "id interactor")
         callback(createCompetitionTableModel(competitionId))
    }

  fun  callTeamcompetitions (competitionId : Int, callback : (Int) -> Unit ) {
        Log.d("okh", competitionId.toString() + "id interactor")
         callback(createCompetitionTeamModel(competitionId))
    }

    private val homeService by lazy {
        Apicalls.create()
    }

    private fun createCompetitionTableModel(competitionId: Int): Int  {
        var tablesModel: TablesEntity
         var names = mutableListOf("")
         var points = mutableListOf("")
         var position = mutableListOf("")
         var goalsFor = mutableListOf("")
         var gamesPlayed = mutableListOf("")
         var teamId = mutableListOf(0)
        Log.d("okh", "$competitionId competitionId")

       try {
           doAsync {
               homeService.getTables("fb72bfd14ba7494da1ccf73acd38afdd", competitionId)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe({ results ->

                       val size = results.standings[0].table.size
                       for (i in 1 until size-1) {
                           names.add(i, results.standings[0].table[i].team.name.toString())
                           teamId.add(i, results.standings[0].table[i].team.id)
                           gamesPlayed.add(i, results.standings[0].table[i].playedGames.toString())
                           goalsFor.add(i, results.standings[0].table[i].goalsFor.toString())
                           points.add(i, results.standings[0].table[i].points.toString())
                           position.add(i, results.standings[0].table[i].position.toString())

                       }


                       doAsync {
                           for (i in 1 until names.size) {
                               tablesModel = TablesEntity(
                                   position[i].toInt(), size.toString(), competitionId,
                                   position[i],
                                   names[i], "",
                                   gamesPlayed[i],
                                   goalsFor[i],
                                   points[i]
                               )
                               Log.d("okh", tablesModel.toString())
                               App.getInstance(this@CompetitionTableInteractor).tablesDao().insert(tablesModel)

                           }
                       }

                   },
                       {
                           Log.d("okherror", "" + it.toString())
                       }
                   )

           }
       }catch (e : Exception){

       }


    return 2
}

    private fun createCompetitionTeamModel(competitionId: Int): Int  {
        var teamsEntity: TeamsEntity
        var names = mutableListOf("")
        var teamLogo = mutableListOf("")
        var teamId = mutableListOf("")
        Log.d("okh", "$competitionId competitionId")

        try {
            doAsync {
                homeService.getTeams("fb72bfd14ba7494da1ccf73acd38afdd", competitionId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ results ->

                        val size = results.teams.size
                        for (i in 1 until size-1) {
                            names.add(i, results.teams[i].name.toString())
                            teamId.add(i, results.teams[i].id.toString())
                            teamLogo.add(i, results.teams[i].crestUrl.toString())

                        }

                        doAsync {
                            for (i in 1 until names.size) {
                                teamsEntity = TeamsEntity(teamId[i].toInt(), names[i], competitionId, teamLogo[i])
                                Log.d("okh", teamsEntity.toString())
                                App.getInstance(this@CompetitionTableInteractor).teamsDao().insert(teamsEntity)

                            }
                        }

                    },
                        {
                            Log.d("okherror", "" + it.toString())
                        }
                    )

            }
        }catch (e : Exception){

        }


        return 2
    }


}
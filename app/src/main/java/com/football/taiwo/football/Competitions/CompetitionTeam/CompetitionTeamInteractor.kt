package com.football.taiwo.football.Competitions.CompetitionTeam

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Database.Team.TeamsEntity
import com.football.taiwo.football.Home.Apicalls
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import java.util.*

class CompetitionTeamInteractor : AppCompatActivity(){

    interface HandleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTeamcompetitions (competitionId : Int, callback : (Int) -> Unit ) {
        Log.d("okh", competitionId.toString() + "id interactor")
        callback(createCompetitionTeamModel(competitionId))
    }

    private val homeService by lazy {
        Apicalls.create()
    }

    private fun createCompetitionTeamModel(competitionId: Int): Int  {
        var teamsEntity: TeamsEntity
        var names = mutableListOf("")
        var teamLogo = mutableListOf("")
        var teamId = mutableListOf("")
        Log.d("okh", "$competitionId competitionId")
        doAsync {
            homeService.getTeams("fb72bfd14ba7494da1ccf73acd38afdd", competitionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    val size = results.teams.size
                    for (i in 1 until size-1) {
                        names.add(i, results.teams[i].name.toString())
                        teamId.add(i, results.teams[i].id.toString())
                        if (results.teams[i].crestUrl == null){
                            results.teams[i].crestUrl = ""
                        }
                        teamLogo.add(i, results.teams[i].crestUrl.toString()+"")

                    }

                    doAsync {
                        for (i in 1 until names.size) {
                            teamsEntity = TeamsEntity(teamId[i].toInt(), names[i], competitionId, teamLogo[i])
                            Log.d("okh", "$teamsEntity teams")
                            App.getInstance(this@CompetitionTeamInteractor).teamsDao().insert(teamsEntity)

                        }
                    }


                },
                    {
                        Log.d("okherror", "" + it.localizedMessage.toString())
                    }
                )

        }

        return 2
    }

}
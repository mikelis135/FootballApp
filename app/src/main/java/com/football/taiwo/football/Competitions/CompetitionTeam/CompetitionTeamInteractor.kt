package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Database.Team.TeamsEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import java.util.*

class CompetitionTeamInteractor : AppCompatActivity(){

    interface handleEvents{
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
        var teamsEntityLists : MutableList<CompetitionTeamModel> = ArrayList()
        var teamsEntityList : MutableList<TeamsEntity> = ArrayList()
        var teamsModelList : MutableList<CompetitionTeamModel> = ArrayList()
        var teamsEntity: TeamsEntity
        var names = mutableListOf("")
        var teamLogo = mutableListOf("")
        var teamId = mutableListOf("")
        Log.d("okh", competitionId.toString() + " competitionId")
        doAsync {
            homeService.getTeams("fb72bfd14ba7494da1ccf73acd38afdd", competitionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    val size = results.teams.size
                    for (i in 1 until size-1) {
                        names.add(i, results.teams.get(i).name.toString())
                        teamId.add(i, results.teams.get(i).id.toString())
                        if (results.teams.get(i).crestUrl == null){
                            results.teams.get(i).crestUrl = ""
                        }
                        teamLogo.add(i, results.teams.get(i).crestUrl.toString()+"")
//                        Log.d("okh", names.toString()+" names")
//                        Log.d("okh", teamLogo.toString()+" logos")

                    }

                    doAsync {
                        for (i in 1 until names.size) {
                            teamsEntity = TeamsEntity(teamId.get(i).toInt(), names.get(i), competitionId, teamLogo.get(i))
                            Log.d("okh", teamsEntity.toString()+" teams")
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
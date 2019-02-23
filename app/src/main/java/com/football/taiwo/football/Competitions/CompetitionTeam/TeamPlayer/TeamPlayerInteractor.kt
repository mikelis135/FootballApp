package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Database.Team.TeamsEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync

class TeamPlayerInteractor : AppCompatActivity() {

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTeamPlayer (teamId : Int, callback : (Int) -> Unit ) {
         callback(createTeamPlayerModel(teamId))
    }

    private val homeService by lazy {
        Apicalls.create()
    }

    private fun createTeamPlayerModel(teamId: Int): Int  {
        var teamsEntityLists : MutableList<CompetitionTeamModel> = java.util.ArrayList()
        var teamsEntityList : MutableList<TeamsEntity> = java.util.ArrayList()
        var teamsModelList : MutableList<CompetitionTeamModel> = java.util.ArrayList()
        var teamsEntity: TeamsEntity
        var names = mutableListOf("")
        var teamLogo = mutableListOf("")
        var playerId = mutableListOf("")
        var playerName = mutableListOf("")
        var playerRole = mutableListOf("")
        var playerShirt = mutableListOf("")

        Log.d("okh", teamId.toString() + " competitionId")
        doAsync {
            homeService.getTeamPlayers("fb72bfd14ba7494da1ccf73acd38afdd", teamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    val size = results.squad.size
                    for (i in 1 until size) {
                        names.add(i, results.name.toString())
                        playerId.add(i, results.squad.get(i).id.toString())
                        playerName.add(i, results.squad.get(i).name.toString())
                        playerRole.add(i, results.squad.get(i).position.toString())
                        playerShirt.add(i, results.squad.get(i).shirtNumber.toString())
                        playerShirt.add(i, results.crestUrl.toString())
                        if (results.crestUrl == null){
                            results.crestUrl = ""
                        }
                        teamLogo.add(i, results.crestUrl.toString()+"")
//                        Log.d("okh", names.toString()+" names")
//                        Log.d("okh", teamLogo.toString()+" logos")

                    }

                    doAsync {
                        for (i in 1 until names.size) {
//                            teamsEntity = TeamsEntity(teamId.get(i).toInt(), names.get(i), competitionId, teamLogo.get(i))
//                            Log.d("okh", teamsEntity.toString()+" teams")
//                            App.getInstance(this@TeamPlayerInteractor).teamsDao().insert(teamsEntity)

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
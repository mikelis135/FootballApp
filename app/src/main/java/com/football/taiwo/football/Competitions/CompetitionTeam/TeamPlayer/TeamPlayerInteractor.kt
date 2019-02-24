package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Database.Team.TeamPlayersEntity
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
        var teamPlayersEntity: TeamPlayersEntity
        var names = mutableListOf("")
        var teamLogo = mutableListOf("")
        var playerId = mutableListOf(0)
        var playerName = mutableListOf("")
        var playerPosition = mutableListOf("")
        var playerShirt = mutableListOf("")

        Log.d("okh", teamId.toString() + " competitionId")
        doAsync {
            homeService.getTeamPlayers("fb72bfd14ba7494da1ccf73acd38afdd", teamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    val size = results.squad.size
                    for (i in 1 until size) {
                        if (results.crestUrl == null){
                            results.crestUrl = ""
                        }
                        if (results.squad.get(i).shirtNumber == null){
                            results.squad.get(i).shirtNumber = i
                        }
                        if (results.squad.get(i).position == null){
                            results.squad.get(i).position = ""
                        }
                        if (results.squad.get(i).id == null){
                            results.squad.get(i).id = 0
                        }
                        if (results.name == null){
                            results.name = ""
                        }
                        names.add(i, results.name.toString())
                        playerId.add(i, results.squad.get(i).id)
                        playerName.add(i, results.squad.get(i).name.toString())
                        playerPosition.add(i, results.squad.get(i).position.toString())
                        teamLogo.add(i, results.crestUrl.toString())
                        playerShirt.add(i, results.squad.get(i).shirtNumber.toString())
                    }

                    doAsync {
                        for (i in 1 until names.size) {
                            teamPlayersEntity = TeamPlayersEntity(playerId.get(i), names.get(i), playerName.get(i), playerShirt.get(i), playerPosition.get(i),  teamId, teamLogo.get(i))
                            Log.d("okh", teamPlayersEntity.toString()+" teamPlayers")
                            App.getInstance(this@TeamPlayerInteractor).teamPlayerDao().insert(teamPlayersEntity)

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
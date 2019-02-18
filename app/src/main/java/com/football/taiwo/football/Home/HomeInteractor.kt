package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.Apimodel.Teams.Team
import com.football.taiwo.football.App
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import com.football.taiwo.football.Database.Tables.TablesEntity
import com.football.taiwo.football.Database.Team.TeamsEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class HomeInteractor : AppCompatActivity() {


    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callFixtures (callback : (FixtureEntity) -> Unit ) {
         callback(createFixtureList())

    }

    fun callCompetitions(callback: (CompetitionEntity) -> Unit) {
           callback(createCompetitionList())
        }

   fun callTable(callback: (TablesEntity) -> Unit) {
           callback(createCompetitionTableModel(0))
        }

    fun callTeam(callback: (TeamsEntity) -> Unit) {
           callback(createCompetitionTeamModel(0))
        }


    private val homeService by lazy {
        Apicalls.create()
    }
    private var disposable: Disposable? = null

    private var fixtureEntity = FixtureEntity(0, "", "", "","","", "")

    private fun createFixtureList(): FixtureEntity {

            doAsync {

                disposable = homeService.getFixtures("fb72bfd14ba7494da1ccf73acd38afdd")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ results ->

                        var count = results.count
                        var size = results.matches.size
                        if (count != null) {
                            for (i in 1 until count) {

                                    if (results.matches.get(i).id==null) {
                                        results.matches.get(i).id = 0
                                    }
                                  if (results.matches.size==null) {
                                      size = 0
                                    }

                                 if (results.matches.get(i).status==null) {
                                     results.matches.get(i).status = ""
                                    }
                                 if (results.matches.get(i).homeTeam.name==null) {
                                     results.matches.get(i).homeTeam.name = ""
                                    }
                                 if (results.matches.get(i).awayTeam.name==null) {
                                     results.matches.get(i).awayTeam.name = ""
                                    }
                                 if (results.matches.get(i).score.fullTime.homeTeam==null) {
                                     results.matches.get(i).score.fullTime.homeTeam = ""
                                    }

                                if (results.matches.get(i).score.fullTime.awayTeam==null) {
                                    results.matches.get(i).score.fullTime.awayTeam = ""
                                    }



                                fixtureEntity = FixtureEntity(
                                    results.matches.get(i).id,
                                    results.matches.size.toString()+"",
                                    results.matches.get(i).status+"", results.matches.get(i).homeTeam.name+"",
                                    results.matches.get(i).awayTeam.name+"", results.matches.get(i).score.fullTime.homeTeam.toString()+"", results.matches.get(i).score.fullTime.awayTeam.toString()+""
                                )
                                doAsync {
                                    App.getInstance(this@HomeInteractor).fixtureDao().insert(fixtureEntity)
                                    uiThread {

                                    }
                                }
                            }
                            Log.d("okh", fixtureEntity.toString()+" new")

                        }

                    },
                        {
                            Log.d("okherror", "" + it.message.toString())
                        }
                    )
                uiThread {

                }
            }

            return fixtureEntity
    }

    private var competitionEntity = CompetitionEntity(0, 0, "")

    private fun createCompetitionList(): CompetitionEntity {

        doAsync {

            disposable = homeService.getCompetitions("fb72bfd14ba7494da1ccf73acd38afdd")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    var count = results.count
                    if (count != null) {
                        for (i in 1 until count) {

                            competitionEntity = CompetitionEntity(
                                results.competitions.get(i).id,
                                results.count,
                                results.competitions.get(i).name
                            )
                            // competitionEntity2 = competitionEntity
                            //return competitionEntity
                            // Log.d("okh", competitionEntity.toString())
                            doAsync {
                                App.getInstance(this@HomeInteractor).competitionDao().insert(competitionEntity)
                                uiThread {
                                    //  Log.d("okh", App.getInstance(this@HomeInteractor).footballDao().allCompetitions().toString())
                                }
                            }
                        }
                        Log.d("okh", competitionEntity.toString())


                    }

                },
                    {
                        Log.d("okh", "" + it.message.toString())
                    }
                )
          uiThread {

          }
        }

        return competitionEntity
}

    var teamsEntity =  TeamsEntity(0, "", "")
    var tablesEntity =  TablesEntity(0, "", "", "", "", "", "", "")

    fun createCompetitionTableModel(id : Int): TablesEntity {

        doAsync {

            Log.d("okh", id.toString()+"id clicked")
            disposable = homeService.getTables("fb72bfd14ba7494da1ccf73acd38afdd", id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    var count = results.standings.size
                    var standing = results.standings
                    if (count != null) {
                        for (i in 1 until standing.get(count).table.size) {

                            if (results.standings.get(i).table.get(i).position==null){
                                results.standings.get(i).table.get(i).position = 0
                            }
                            if (results.standings.get(i).table.get(i).team.name==null){
                                results.standings.get(i).table.get(i).team.name = ""
                            }
                            if (results.standings.get(i).table.get(i).team.crestUrl==null){
                                results.standings.get(i).table.get(i).team.crestUrl = ""
                            }
                            if (results.standings.get(i).table.get(i).playedGames==null){
                                results.standings.get(i).table.get(i).playedGames = 0
                            }
                            if (results.standings.get(i).table.get(i).goalsFor==null){
                                results.standings.get(i).table.get(i).goalsFor = 0
                            }
                             if (results.standings.get(i).table.get(i).points==null){
                                 results.standings.get(i).table.get(i).points = 0
                            }

                            tablesEntity = TablesEntity(
                                results.standings.get(i).table.get(i).position,
                                results.standings.size.toString(),
                                results.standings.get(i).table.get(i).position.toString(), results.standings.get(i).table.get(i).team.name,
                                results.standings.get(i).table.get(i).team.crestUrl, results.standings.get(i).table.get(i).playedGames.toString(),
                                results.standings.get(i).table.get(i).goalsFor.toString(), results.standings.get(i).table.get(i).points.toString()
                            )

                            doAsync {
                                App.getInstance(this@HomeInteractor).tablesDao().insert(tablesEntity)
                                uiThread {

                                }
                            }
                        }
                        Log.d("okh", tablesEntity.toString())

                    }

                },
                    {
                        Log.d("okh", "" + it.message.toString())
                    }
                )
            uiThread {

            }
        }

        return tablesEntity
    }

    fun createCompetitionTeamModel(id : Int): TeamsEntity {

        doAsync {

            Log.d("okh", id.toString()+"id clicked")
            disposable = homeService.getTeam("fb72bfd14ba7494da1ccf73acd38afdd", id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    var count = results.count
                    var teams = results.teams
                    if (count != null) {
                        for (i in 1 until count) {

                            if (results.teams.get(i).id==null){
                                results.teams.get(i).id = 0
                            }
                            if (results.teams.get(i).name==null){
                                results.teams.get(i).name = ""
                            }
                            if (results.teams.get(i).crestUrl==null){
                                results.teams.get(i).crestUrl = ""
                            }

                            teamsEntity = TeamsEntity(results.teams.get(i).id, results.teams.get(i).name, results.teams.get(i).crestUrl)

                            doAsync {
                                App.getInstance(this@HomeInteractor).teamsDao().insert(teamsEntity)
                                uiThread {

                                }
                            }
                        }
                        Log.d("okh", teamsEntity.toString())

                    }

                },
                    {
                        Log.d("okh", "" + it.message.toString())
                    }
                )
            uiThread {

            }
        }

        return teamsEntity
    }


}

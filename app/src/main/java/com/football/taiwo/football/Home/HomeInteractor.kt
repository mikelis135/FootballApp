package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class HomeInteractor : AppCompatActivity() {


    interface HandleEvents{
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callFixtures (callback : (FixtureEntity) -> Unit ) {
         callback(createFixtureList())

    }

    fun callCompetitions(callback: (CompetitionEntity) -> Unit) {
           callback(createCompetitionList())
        }

    private val homeService by lazy {
        Apicalls.create()
    }
    private var disposable: Disposable? = null

    private var fixtureEntity = FixtureEntity(0, "", "", "", "","","", "")

    private fun createFixtureList(): FixtureEntity {

            try {
                doAsync {

                    disposable = homeService.getFixtures("fb72bfd14ba7494da1ccf73acd38afdd")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ results ->

                            var count = results.count
                            var time : String = ""
                            var score1 : String = ""
                            var score2 : String  = ""

                            if (count != null) {
                                for (i in 1 until count) {

                                    if (results.matches[i].id==null) {
                                        results.matches[i].id = 0
                                    }
                                    if (results.matches[i].status==null) {
                                        results.matches[i].status = ""
                                    }
                                    if (results.matches[i].homeTeam.name==null) {
                                        results.matches[i].homeTeam.name = ""
                                    }
                                    if (results.matches[i].awayTeam.name==null) {
                                        results.matches[i].awayTeam.name = ""
                                    }
                                    if (results.matches[i].score.fullTime.homeTeam==null) {
                                        results.matches[i].score.fullTime.homeTeam = ""
                                    }
                                    else{
                                        score1 = results.matches[i].score.fullTime.homeTeam.toString().substring(0,1)
                                    }
                                    if (results.matches[i].score.fullTime.awayTeam==null) {
                                        results.matches[i].score.fullTime.awayTeam = ""
                                    }
                                    else{
                                        score2 = results.matches[i].score.fullTime.awayTeam.toString().substring(0,1)
                                    }
                                    if (results.matches[i].lastUpdated==null) {
                                        results.matches[i].lastUpdated = ""
                                    }
                                    else{
                                        val timearray = results.matches[i].lastUpdated.split("T")
                                        time =   timearray[1].substring(0,5)
                                    }

                                    Log.d("okh", "$time time of the match")
                                    Log.d("okh", "$score1 score1 of the match")
                                    Log.d("okh", "$score2 score2 of the match")

                                    fixtureEntity = FixtureEntity(
                                        results.matches[i].id,
                                        results.matches.size.toString()+"",time,
                                        results.matches[i].status+"", results.matches[i].homeTeam.name+"",
                                        results.matches[i].awayTeam.name+"", score1, score2
                                    )
                                    doAsync {
                                        App.getInstance(this@HomeInteractor).fixtureDao().insert(fixtureEntity)
                                        uiThread {

                                        }
                                    }
                                }
                                Log.d("okh", "$fixtureEntity new")

                            }

                        },
                            {
                                Log.d("okherror", "" + it.message.toString())
                            }
                        )
                    uiThread {

                    }
                }
            }catch (e : Exception){

            }


            return fixtureEntity
    }

    private var competitionEntity = CompetitionEntity(0, 0, "")

    private fun createCompetitionList(): CompetitionEntity {


       try {
           doAsync {

               disposable = homeService.getCompetitions("fb72bfd14ba7494da1ccf73acd38afdd")
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe({ results ->

                       var count = results.count
                       if (count != null) {
                           for (i in 1 until count) {

                               competitionEntity = CompetitionEntity(
                                   results.competitions[i].id,
                                   results.count,
                                   results.competitions[i].name
                               )

                               doAsync {
                                   App.getInstance(this@HomeInteractor).competitionDao().insert(competitionEntity)
                                   uiThread {

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
       }catch (e : Exception){

       }


        return competitionEntity
}

}


package com.football.taiwo.football.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.App
import com.football.taiwo.football.Database.Tables.TablesEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CompetitionTableInteractor : AppCompatActivity(){

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTablecompetitions (callback : (TablesEntity) -> Unit ) {
        callback(createCompetitionTableModel(2013))
    }


    val homeService by lazy {
        Apicalls.create()
    }
    var disposable: Disposable? = null

    var tablesEntity =  TablesEntity(0, "", "", "","","", "", "")


    private fun createCompetitionTableModel(id : Int): TablesEntity {

        doAsync {

            Log.d("okh", id.toString()+"id clicked")
            disposable = homeService.getTables("fb72bfd14ba7494da1ccf73acd38afdd", id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->

                    var count = results.standings.size
                    Log.d("okh", "standing size" + count)
                    if (count != null) {
                        for (i in 1 until count) {

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
                                results.standings.size,
                                results.standings.size.toString(),
                                results.standings.get(i).table.get(i).position.toString(), results.standings.get(i).table.get(i).team.name,
                                results.standings.get(i).table.get(i).team.crestUrl, results.standings.get(i).table.get(i).playedGames.toString(),
                                results.standings.get(i).table.get(i).goalsFor.toString(), results.standings.get(i).table.get(i).points.toString()
                            )
                            Log.d("okh", tablesEntity.toString()+ "interact")
                            doAsync {
                                App.getInstance(this@CompetitionTableInteractor).tablesDao().insert(tablesEntity)
                                uiThread {

                                }
                            }

                        }


                    }



                },
                    {
                        Log.d("okh", "" + it.message.toString()+" error")
                    }
                )
            uiThread {

            }
        }

        return tablesEntity
    }

}
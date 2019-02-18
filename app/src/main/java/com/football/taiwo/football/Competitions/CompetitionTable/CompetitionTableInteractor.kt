package com.football.taiwo.football.Home

import androidx.appcompat.app.AppCompatActivity
import com.football.taiwo.football.Database.Tables.TablesEntity
import io.reactivex.disposables.Disposable

class CompetitionTableInteractor : AppCompatActivity(){

    interface handleEvents{
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun  callTablecompetitions (callback : (TablesEntity) -> Unit ) {

     //   callback(createCompetitionTableModel(0))
    }

    var tablesEntity =  TablesEntity(0, "", "", "","","", "", "")
    var disposable: Disposable? = null
    val homeService by lazy {
        Apicalls.create()
    }

//    private fun createCompetitionTableModel(id : Int): TablesEntity {
//
//        doAsync {
//
//            Log.d("okh", id.toString()+"id clicked")
//            disposable = homeService.getTables("fb72bfd14ba7494da1ccf73acd38afdd", id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ results ->
//
//                    var count = results.standings.size
//                    if (count != null) {
//                        for (i in 1 until count) {
//
//                            tablesEntity = TablesEntity(
//                                results.standings.size,
//                                results.standings.size.toString(),
//                                results.standings.get(i).table.get(i).position.toString(), results.standings.get(i).table.get(i).team.name,
//                                results.standings.get(i).table.get(i).team.crestUrl, results.standings.get(i).table.get(i).playedGames.toString(),
//                                results.standings.get(i).table.get(i).goalsFor.toString(), results.standings.get(i).table.get(i).points.toString()
//                            )
//
//                            doAsync {
//                                App.getInstance(this@CompetitionTableInteractor).tablesDao().insert(tablesEntity)
//                                uiThread {
//
//                                }
//                            }
//                        }
//                        Log.d("okh", tablesEntity.toString())
//
//                    }
//
//                },
//                    {
//                        Log.d("okh", "" + it.message.toString())
//                    }
//                )
//            uiThread {
//
//            }
//        }
//
//        return tablesEntity
//    }

}
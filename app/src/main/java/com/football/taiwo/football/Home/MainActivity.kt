package com.football.taiwo.football.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.Competition
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import com.football.taiwo.football.Home.Competitions.CompetitionAdapter
import com.football.taiwo.football.Home.Fixtures.FixtureAdapter
import com.football.taiwo.football.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), HomeView{

    //home presenter declaration
    private val homePresenter = HomePresenter(homeView = this, homeInteractor = HomeInteractor())

    var snackbar : Snackbar ?= null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_fixtures -> {
                homePresenter.onLoadStart()
                //loading the fixtures
                homePresenter.loadFixtures()
                snackbar!!.setText("Loading Fixtures")
                homePresenter.onLoadFinished()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_competitions -> {
                homePresenter.onLoadStart()
                //loading the competitions
                homePresenter.loadCompetitions()
                snackbar!!.setText("Loading Competitions")
                homePresenter.onLoadFinished()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun showShimmer() {
        //show progress bar when loading fixtures and competitions
        //snackbar!!.show()
    }

    override fun stopShimmer() {
        //hide progress bar after loading fixtures and competitions
       // snackbar!!.dismiss()
    }

    override fun onResume() {
        //refresh the UI with call from the Database
        callFixtureDB()
        callCompetitionDB()
        super.onResume()

    }

    private fun callFixtureDB(){

        //get the fixture gotten from the api that has been stored in the database
        var listfootball : MutableList<FixtureEntity> = ArrayList()
        doAsync {
            val list = App.getInstance(applicationContext).fixtureDao().allFixtures()

            uiThread {
                for (football in 0 until list.size) {
                    listfootball.add(football, list[football])
                    Log.d("okh", listfootball.toString())
                }

                var fixtureAdapter = FixtureAdapter(this@MainActivity, listfootball, homePresenter::onFixtureItemClicked)
                homeRecylerView.adapter = fixtureAdapter
                fixtureAdapter.setItems(listfootball)
            }
        }

    }

    override fun setFixtureItems() {
        callFixtureDB()
    }

    override fun setCompetitionItems() {
        callCompetitionDB()
    }

    private fun callCompetitionDB(){
        var listfootball : MutableList<CompetitionEntity> = ArrayList()
        //get the competition gotten from the api that has been stored in the database

        doAsync {
            val list = App.getInstance(applicationContext).competitionDao().allCompetitions()
            uiThread {
                for (football in 0 until list.size) {
                    listfootball.add(football, list[football])
                }
                var homeAdapter = CompetitionAdapter(this@MainActivity, listfootball, homePresenter::onCompetitionItemClicked)
                homeRecylerView.adapter = homeAdapter
            }
        }

    }

    override fun openCompetitionsPage(competition : Int, competitionName : String) {

        // open the Competition page when the competition is clicked
        val intent = Intent(this@MainActivity, Competition::class.java)
        intent.putExtra(getString(R.string.competition), competition.toString())
        intent.putExtra(getString(R.string.competition_title), competitionName)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up of the layout manager for the recycler view
        var mLayoutManager = GridLayoutManager(this, 1)
        homeRecylerView.layoutManager = mLayoutManager
        snackbar = Snackbar.make(homeRecylerView, "Fixture Loaded", Snackbar.LENGTH_SHORT)
        homePresenter.loadFixtures()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
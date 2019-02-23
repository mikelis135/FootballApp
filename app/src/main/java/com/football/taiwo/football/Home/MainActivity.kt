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
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), HomeView{

    private val homePresenter = HomePresenter(homeView = this, homeInteractor = HomeInteractor())
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_fixtures -> {
              //  message.setText(R.string.title_fixture)
                homePresenter.loadFixtures()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_competitions -> {
               // message.setText(R.string.title_competitions)
                homePresenter.loadCompetitions()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun showShimmer() {
    }

    override fun stopShimmer() {
    }

    override fun onResume() {
        homePresenter.loadFixtures()
        super.onResume()
    }

    fun callFixtureDB(){
        var listfootball : MutableList<FixtureEntity> = ArrayList()
        doAsync {
            val list = App.getInstance(applicationContext).fixtureDao().allFixtures()
            uiThread {
                for (football in 0 until list.size) {
                    listfootball.add(football, list.get(football))
                    Log.d("okh", listfootball.toString())
                    // toast(list.get(football).fixtureAwayTeam)
                    var fixtureAdapter = FixtureAdapter(this@MainActivity, listfootball, homePresenter::onFixtureItemClicked)
                    homeRecylerView.adapter = fixtureAdapter
                }

            }
        }
    }

    override fun setFixtureItems(items: FixtureEntity) {
        callFixtureDB()
    }

    override fun setCompetitionItems(items: CompetitionEntity) {
        callCompetitionDB()
    }

    fun callCompetitionDB(){
        var listfootball : MutableList<CompetitionEntity> = ArrayList()
        doAsync {
            val list = App.getInstance(applicationContext).competitionDao().allCompetitions()
            uiThread {
                for (football in 0 until list.size) {
                    listfootball.add(football, list.get(football))
                    //    toast(list.get(football).competitionName)
                }
                var homeAdapter = CompetitionAdapter(this@MainActivity, listfootball, homePresenter::onCompetitionItemClicked)
                homeRecylerView.adapter = homeAdapter
            }
        }
    }

    override fun openCompetitionsPage(competition : Int, competitionName : String) {
        val intent = Intent(this@MainActivity, Competition::class.java)
        intent.putExtra(getString(R.string.competition), competition.toString())
        intent.putExtra(getString(R.string.competition_title), competitionName)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mLayoutManager = GridLayoutManager(this, 1)
        homeRecylerView.layoutManager = mLayoutManager

        homePresenter.loadFixtures()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

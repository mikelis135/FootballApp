package com.football.taiwo.football.Competitions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableFragment
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableView
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamFragment
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Home.CompetitionTableInteractor
import com.football.taiwo.football.Home.CompetitionTablePresenter
import com.football.taiwo.football.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_competition.*

class Competition : AppCompatActivity(), CompetitionTableView {

    override fun setTable(competitionId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val competitionPresenter = CompetitionTablePresenter(this, CompetitionTableInteractor())


    override fun showShimmer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopShimmer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    companion object {
        var competitionID : Int = 0
    }
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)
        setSupportActionBar(toolbar)
        val competitionTitle = intent

        competitionID = competitionTitle.getStringExtra(getString(R.string.competition)).toInt()
        val competitionName = competitionTitle.getStringExtra(getString(R.string.competition_title))
        Log.d("okh", "$competitionID $competitionName")

        title = competitionName
        supportActionBar!!.setTitle(competitionName)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        competitionContainer.adapter = mSectionsPagerAdapter
       // loadTableCompetitions
        competitionContainer.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(competitionContainer))

    }

    override fun onResume() {
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        competitionContainer.adapter = mSectionsPagerAdapter
        // loadTableCompetitions
        competitionContainer.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(competitionContainer))
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_competition, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            var fragment : Fragment? = null
            if (position==0) {
                fragment = CompetitionTableFragment.newInstance(competitionID)
            }
            else if (position==1) {
                fragment = CompetitionTableFragment.newInstance(competitionID)
            }
            else if (position==2) {
                fragment = CompetitionTeamFragment.newInstance(competitionID)
            }
            return fragment!!
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }


}

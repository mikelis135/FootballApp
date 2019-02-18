package com.football.taiwo.football.Competitions

import android.content.Context
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableFragment
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamFragment
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.activity_competition.*

class Competition : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    val competitionID : Int = 0
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)
        setSupportActionBar(toolbar)
        val competitionTitle = intent
        val competitionID = competitionTitle.getStringExtra(getString(R.string.competition))
        val competitionName = competitionTitle.getStringExtra(getString(R.string.competition_title))
        Log.d("okh", competitionID + " " + competitionName)
        title = competitionName
        supportActionBar!!.setTitle(competitionName)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        competitionContainer.adapter = mSectionsPagerAdapter

        competitionContainer.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(competitionContainer))

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
            if (position==0) {
                return CompetitionTableFragment.newInstance(competitionID)
            }
            else if (position==1) {
                return CompetitionTableFragment.newInstance(competitionID)
            }
            else if (position==2) {
                return CompetitionTeamFragment.newInstance(competitionID)
            }
            return CompetitionTableFragment.newInstance(competitionID)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }


}

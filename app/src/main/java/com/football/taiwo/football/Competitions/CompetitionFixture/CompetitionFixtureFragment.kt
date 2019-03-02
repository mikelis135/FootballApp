package com.football.taiwo.football.Competitions.CompetitionFixture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.football.taiwo.football.Competitions.Competition
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableFragment
import com.football.taiwo.football.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_competition.*
import kotlinx.android.synthetic.main.fragment_competition_table.*
import kotlinx.android.synthetic.main.fragment_competition_table.view.*

class CompetitionFixtureFragment : androidx.fragment.app.Fragment(), CompetitionFixtureView {

    private var rootView : View? = null
    private val competitionFixturePresenter = CompetitionFixturePresenter(competitionView = this, competitionInteractor = CompetitionFixtureInteractor())


    var snackbar : Snackbar ?= null
    var homeAdapter = CompetitionFixtureAdapter(
        activity,
        null,
        competitionFixturePresenter::onCompetitionFixtureClicked
    )
    override fun stopShimmer() {
       // progressCompetition.visibility = View.INVISIBLE
        snackbar!!.setText("Competition Standings Loaded")
        snackbar!!.dismiss()
    }

    var items2 : MutableList<CompetitionFixtureModel> ?= null

    override fun setFixture(items: MutableList<CompetitionFixtureModel>) {

        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 1)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        var homeAdapter = CompetitionFixtureAdapter(
            activity,
            items,
            competitionFixturePresenter::onCompetitionFixtureClicked
        )
        items2 = items
        rootView!!.competitionRecylerView.adapter = homeAdapter
        Log.d("okh", "setteam")
        stopShimmer()
    }

    fun callCompetition(){
        showShimmer()
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 1)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        var homeAdapter = CompetitionFixtureAdapter(
            activity,
            items2,
            competitionFixturePresenter::onCompetitionFixtureClicked
        )
        rootView!!.competitionRecylerView.adapter = homeAdapter
        Log.d("okh", "setteam")
        competitionFixturePresenter.onLoadFinished()
        stopShimmer()
    }

    override fun onResume() {
        callCompetition()
        super.onResume()

    }

    override fun showShimmer() {
      //  progressCompetition.visibility = View.VISIBLE
        snackbar!!.setText("Loading Competition Standings")
        //val snackbar = Snackbar.make(rootView!!, "Loading Fixtures", Snackbar.LENGTH_LONG)
        snackbar!!.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        //competitionTeamRecylerView
        rootView = inflater.inflate(R.layout.fragment_competition_table, container, false)
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 1)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        competitionFixturePresenter.loadFixtureCompetitions()
        snackbar = Snackbar.make(rootView!!.competitionRecylerView, "Competition Standings Loaded", Snackbar.LENGTH_SHORT)
        competitionFixturePresenter.onLoadFinished()
        rootView!!.competitionRecylerView.adapter = homeAdapter
        rootView!!.section_label.text = getString(
            R.string.section_format, arguments?.getInt(
                ARG_SECTION_NUMBER
            ))
        return rootView
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CompetitionFixtureFragment {

            val fragment = CompetitionFixtureFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
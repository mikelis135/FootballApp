package com.football.taiwo.football.Competitions.CompetitionFixture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.fragment_competition_table.view.*

class CompetitionFixtureFragment : androidx.fragment.app.Fragment(), CompetitionFixtureView {

    private var rootView : View? = null
    private val competitionFixturePresenter = CompetitionFixturePresenter(competitionView = this, competitionInteractor = CompetitionFixtureInteractor())

    override fun stopShimmer() {

    }

    override fun setFixture(items: MutableList<CompetitionFixtureModel>) {
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 1)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        var homeAdapter = CompetitionFixtureAdapter(
            activity,
            items,
            competitionFixturePresenter::onCompetitionFixtureClicked
        )
        rootView!!.competitionRecylerView.adapter = homeAdapter

        Log.d("okh", "setteam")
    }

    override fun showShimmer() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        //competitionTeamRecylerView
        rootView = inflater.inflate(R.layout.fragment_competition_table, container, false)
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 3)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        competitionFixturePresenter.loadFixtureCompetitions()
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
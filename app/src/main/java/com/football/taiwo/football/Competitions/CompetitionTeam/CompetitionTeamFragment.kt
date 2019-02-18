package com.football.taiwo.football.Competitions.CompetitionTeam

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.football.taiwo.football.Competitions.Competition
import com.football.taiwo.football.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.football.taiwo.football.Competitions.CompetitionTable.CompetitionTableModel
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayer
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayerModel
import com.football.taiwo.football.Competitions.CompetitionView
import com.football.taiwo.football.Home.*
import com.football.taiwo.football.R
import com.football.taiwo.football.R.string.competition
import kotlinx.android.synthetic.main.fragment_competition_table.view.*

class CompetitionTeamFragment : androidx.fragment.app.Fragment(), CompetitionTeamView {

    private var rootView : View? = null
    private val competitionTeamPresenter = CompetitionTeamPresenter(this, CompetitionTeamInteractor())
    override fun stopShimmer() {

    }

    override fun setTeams(items: MutableList<CompetitionTeamModel>) {
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 3)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        var homeAdapter = CompetitionTeamAdapter(
            activity,
            items,
            competitionTeamPresenter::onCompetitionTeamClicked
        )
        rootView!!.competitionRecylerView.adapter = homeAdapter

        Log.d("okh", "setteam")
    }

    override fun showShimmer() {

    }

    override fun openTeamPlayerPage(position: Int, items: CompetitionTeamModel) {
        val intent = Intent(activity, TeamPlayer::class.java)
        intent.putExtra(getString(R.string.competition), items)
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        //competitionTeamRecylerView
        rootView = inflater.inflate(R.layout.fragment_competition_table, container, false)
        competitionTeamPresenter.loadTeamCompetitions()
        rootView!!.section_label.text = getString(
            R.string.section_format, arguments?.getInt(
                ARG_SECTION_NUMBER
            ))
        return rootView
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CompetitionTeamFragment {
            val fragment = CompetitionTeamFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
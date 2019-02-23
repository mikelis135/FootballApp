package com.football.taiwo.football.Competitions.CompetitionTeam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.Competition.Companion.competitionID
import com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer.TeamPlayer
import com.football.taiwo.football.Database.Team.TeamsEntity
import com.football.taiwo.football.Home.CompetitionTeamInteractor
import com.football.taiwo.football.Home.CompetitionTeamPresenter
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.fragment_competition_table.view.*
import kotlinx.android.synthetic.main.fragment_competition_team.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CompetitionTeamFragment : androidx.fragment.app.Fragment(), CompetitionTeamView {

    private var rootView : View? = null
    private val competitionTeamPresenter = CompetitionTeamPresenter(this, CompetitionTeamInteractor())
    override fun stopShimmer() {

    }

    override fun setTeams(competititonId : Int) {
//        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 3)
//        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        doAsync {
            var teamsList =   App.getInstance(context!!).teamsDao().allTeams(2013)
            Log.d("okh", teamsList.toString()+" from teamfragment")

            uiThread {

                var teamsEntity : MutableList<TeamsEntity> = ArrayList()
                for (football in 0 until teamsList.size) {
                    teamsEntity.add(football, teamsList.get(football))
                    Log.d("okh", teamsList.get(football).teamName+" from team fragment")

                    var teamAdapter = CompetitionTeamAdapter(activity, teamsEntity, competitionTeamPresenter::onCompetitionTeamClicked)
                    rootView!!.competitionTeamRecylerView.adapter = teamAdapter
                }

            }
        }

    }

    override fun onResume() {
        callTeams()
        super.onResume()
    }

    private fun callTeams(){
        doAsync {
            var teamsList =   App.getInstance(context!!).teamsDao().allTeams(competitionID)
            Log.d("okh", teamsList.toString()+" from teamfragment")

            uiThread {

                var teamsEntity : MutableList<TeamsEntity> = ArrayList()
                for (football in 0 until teamsList.size) {
                    teamsEntity.add(football, teamsList.get(football))
                    Log.d("okh", teamsList.get(football).teamName+" from team fragment")

                    var teamAdapter = CompetitionTeamAdapter(activity, teamsEntity, competitionTeamPresenter::onCompetitionTeamClicked)
                    rootView!!.competitionTeamRecylerView.adapter = teamAdapter
                }

            }
        }
    }

    override fun showShimmer() {

    }

    override fun openTeamPlayerPage(position: Int, items: MutableList<TeamsEntity>) {
        val intent = Intent(activity, TeamPlayer::class.java)
        intent.putExtra(getString(R.string.competition), items.get(position))
        intent.putExtra(getString(R.string.position), position)
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        rootView = inflater.inflate(R.layout.fragment_competition_team, container, false)
        competitionTeamPresenter.loadTeamCompetitions(competitionID)
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 3)
        rootView!!.competitionTeamRecylerView.layoutManager = mLayoutManager
      //  rootView!!.section_label.text = getString(
//            R.string.section_format, arguments?.getInt(
//                ARG_SECTION_NUMBER
//            ))
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
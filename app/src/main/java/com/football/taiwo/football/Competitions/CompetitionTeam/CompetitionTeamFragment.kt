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
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.fragment_competition_team.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CompetitionTeamFragment : androidx.fragment.app.Fragment(), CompetitionTeamView {

    private var rootView : View? = null
    private val competitionTeamPresenter = CompetitionTeamPresenter(this, CompetitionTeamInteractor())
    override fun stopShimmer() {

    }

    override fun setTeams(competititonId : Int) {
        doAsync {
            var teamsList =   App.getInstance(context!!).teamsDao().allTeams(2013)
            Log.d("okh", "$teamsList from teamfragment")

            uiThread {

                var teamsEntity : MutableList<TeamsEntity> = ArrayList()
                for (football in 0 until teamsList.size) {
                    teamsEntity.add(football, teamsList[football])
                    Log.d("okh", teamsList[football].teamName+" from team fragment")

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
            Log.d("okh", "$teamsList from teamfragment")

            uiThread {

                var teamsEntity : MutableList<TeamsEntity> = ArrayList()
                for (football in 0 until teamsList.size) {
                    teamsEntity.add(football, teamsList[football])
                    Log.d("okh", teamsList[football].teamName+" from team fragment")

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
        intent.putExtra(getString(R.string.competition), items[position])
        intent.putExtra(getString(R.string.position), position)
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        rootView = inflater.inflate(R.layout.fragment_competition_team, container, false)
        competitionTeamPresenter.loadTeamCompetitions(competitionID)
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 3)
        rootView!!.competitionTeamRecylerView.layoutManager = mLayoutManager

        return rootView
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CompetitionTeamFragment {
            val fragment = CompetitionTeamFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
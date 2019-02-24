package com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.Competition
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamAdapter
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.teamPlayer.TeamPlayer.TeamPlayerAdapter
import com.football.taiwo.football.Database.Team.TeamPlayersEntity
import com.football.taiwo.football.Database.Team.TeamsEntity
import com.football.taiwo.football.Home.TeamPlayerInteractor
import com.football.taiwo.football.Home.TeamPlayerPresenter
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.activity_team_player.*
import kotlinx.android.synthetic.main.fragment_competition_team.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPlayer : AppCompatActivity(), TeamPlayerView {

    private val teamPlayerPresenter = TeamPlayerPresenter(this, TeamPlayerInteractor())

    override fun showShimmer() {

    }

    override fun stopShimmer() {

    }

    override fun setTeamPlayer(teamId: Int) {

        doAsync {
            var teamPlayersList =   App.getInstance(this@TeamPlayer!!).teamPlayerDao().allTeams(teamId)
            Log.d("okh", teamPlayersList.toString()+" from teamplayerfragment")

            uiThread {
                playerTeamName.text = teamPlayersList.get(0).teamName
                Log.d("Okh", teamPlayersList.get(0).teamName+"")
                var teamsPlayersEntity : MutableList<TeamPlayersEntity> = ArrayList()
                for (football in 0 until teamPlayersList.size) {
                    teamsPlayersEntity.add(football, teamPlayersList.get(football))
                    Log.d("okh", teamPlayersList.get(football).teamName+" from team fragment")

                    var homeAdapter = TeamPlayerAdapter(this@TeamPlayer, teamsPlayersEntity, teamPlayerPresenter::onTeamPlayerClicked)
                    playerRecylerView.adapter = homeAdapter
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_player)

        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 1)
        playerRecylerView.layoutManager = mLayoutManager
        val playerIntent = intent
        val position = playerIntent.extras!!.getInt(getString(R.string.position), 0)

        teamPlayerPresenter.loadTeamPlayer(position)

    }
}
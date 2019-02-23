package com.football.taiwo.football.Competitions.CompetitionTeam.TeamPlayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.football.taiwo.football.Competitions.CompetitionTeam.CompetitionTeamModel
import com.football.taiwo.football.Competitions.teamPlayer.TeamPlayer.TeamPlayerAdapter
import com.football.taiwo.football.Database.Team.TeamsEntity
import com.football.taiwo.football.Home.TeamPlayerInteractor
import com.football.taiwo.football.Home.TeamPlayerPresenter
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.activity_team_player.*

class TeamPlayer : AppCompatActivity(), TeamPlayerView {

    private val teamPlayerPresenter = TeamPlayerPresenter(this, TeamPlayerInteractor())

    override fun showShimmer() {

    }

    override fun stopShimmer() {

    }

    override fun setTeamPlayer(items: MutableList<TeamPlayerModel>) {
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 1)
        playerRecylerView.layoutManager = mLayoutManager
        val playerIntent = intent
        var teamPlayerList : MutableList<TeamPlayerModel> ? = ArrayList()
       // var teamPlayerModel : TeamPlayerModel()
        val teamPlayer = playerIntent.extras!!.getSerializable(getString(R.string.competition)) as MutableList<TeamPlayerModel>
        val position = playerIntent.extras!!.getInt(getString(R.string.position), 0)
        playerTeamName.text = teamPlayer.get(position).teamName
        for (i in 1 until teamPlayer.size){
//            teamPlayerModel = TeamPlayerModel(position, teamPlayer.get(i).)
//            teamPlayerList!!.add(i, teamPlayerModel)
        }
        playerTeamLogo.setImageResource(R.mipmap.ic_launcher)
        var homeAdapter = TeamPlayerAdapter(this, teamPlayer, teamPlayerPresenter::onTeamPlayerClicked)
        playerRecylerView.adapter = homeAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_player)

        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 1)
        playerRecylerView.layoutManager = mLayoutManager
        teamPlayerPresenter.loadTeamPlayer()

       // playerTeamName.text = "Manchester United FC"

    }
}

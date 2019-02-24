package com.football.taiwo.football.Competitions.teamPlayer.TeamPlayer

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.football.taiwo.football.Database.Team.TeamPlayersEntity
import com.football.taiwo.football.R

class TeamPlayerAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<TeamPlayerAdapter.MyViewHolder>() {

    var context : Context? = null
    var teamPlayerList : MutableList<TeamPlayersEntity>? = null
    lateinit var listener : (Int, MutableList<TeamPlayersEntity>) -> Unit


    constructor(context: Context?, teamPlayerList: MutableList<TeamPlayersEntity>?, listener : (Int, MutableList<TeamPlayersEntity>) -> Unit) : this() {
        this.context = context
        this.teamPlayerList = teamPlayerList
        this.listener = listener
    }

    class MyViewHolder : androidx.recyclerview.widget.RecyclerView.ViewHolder {


        var teamPlayerShirt : TextView?= null
        var teamPlayerName : TextView? = null
        var teamPlayerRole : TextView? = null

         constructor(v: View) : super(v){
             this.teamPlayerShirt = v.findViewById(R.id.teamPlayerShirt)
             this.teamPlayerName = v.findViewById(R.id.teamPlayerName)
             this.teamPlayerRole = v.findViewById(R.id.teamPlayerRole)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.team_player_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  teamPlayerList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = teamPlayerList!![position]
        holder.teamPlayerShirt!!.text = item.playerShirt
        holder.teamPlayerName!!.text = item.playerName
        holder.teamPlayerRole!!.text = item.playerPosition
        Log.d("okh", item.playerName+" playeradapter")
//        holder.card_view!!.setOnClickListener { listener(position, teamPlayerList!!) }
    }


}

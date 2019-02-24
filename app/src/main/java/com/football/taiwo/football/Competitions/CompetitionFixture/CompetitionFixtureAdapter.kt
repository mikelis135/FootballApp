package com.football.taiwo.football.Competitions.CompetitionFixture

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.football.taiwo.football.R

class CompetitionFixtureAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<CompetitionFixtureAdapter.MyViewHolder>() {

    var context : Context? = null
    var competitionTeamList : MutableList<CompetitionFixtureModel>? = null
    lateinit var listener : (Int, MutableList<CompetitionFixtureModel>) -> Unit


    constructor(context: Context?, competitionTeamList: MutableList<CompetitionFixtureModel>?, listener : (Int, MutableList<CompetitionFixtureModel>) -> Unit) : this() {
        this.context = context
        this.competitionTeamList = competitionTeamList
        this.listener = listener
    }

    class MyViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {

        var competitionTeamLogo :  ImageView? = null
        var competitionTeamName :  TextView? = null
        var card_view :  androidx.cardview.widget.CardView? = null

        init {
            this.competitionTeamLogo = v.findViewById(R.id.competitionTeamLogo)
            this.competitionTeamName = v.findViewById(R.id.competitionTeamName)
            this.card_view = v.findViewById(R.id.card_view)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.competition_team_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  competitionTeamList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = competitionTeamList!![position]
       // holder.teamRank!!.text = item.id.toString()
        holder.competitionTeamLogo!!.setImageResource(R.mipmap.ic_launcher_round)
        holder.competitionTeamName!!.text = item.teamName
        holder.card_view!!.setOnClickListener { listener(position, competitionTeamList!!) }
    }


}

package com.football.taiwo.football.Home.Fixtures

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.football.taiwo.football.Database.Fixture.FixtureEntity
import com.football.taiwo.football.R

class FixtureAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<FixtureAdapter.MyViewHolder>() {

    var context : Context? = null
    var fixureList : MutableList<FixtureEntity>? = null
    lateinit var listener : (Int, MutableList<FixtureEntity>) -> Unit


    constructor(context: Context?, fixureList: MutableList<FixtureEntity>?, listener : (Int, MutableList<FixtureEntity>) -> Unit) : this() {
        this.context = context
        this.fixureList = fixureList
        this.listener = listener
    }

    class MyViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {

        var fixtureStatus :  TextView? = null
        var fixtureTime :  TextView? = null
        var fixtureMD :  TextView? = null
        var fixtureTeam1 :  TextView? = null
        var fixtureTeam2 :  TextView? = null
        var fixtureExtra :  TextView? = null
        var fixtureScore1 :  TextView? = null
        var fixtureScore2 :  TextView? = null
        var card_view :  androidx.cardview.widget.CardView? = null

        init {
            this.fixtureStatus = v.findViewById(R.id.fixtureStatus)
            this.fixtureTime = v.findViewById(R.id.fixtureTime)
            this. fixtureMD = v.findViewById(R.id.fixtureMD)
            this.fixtureTeam1 = v.findViewById(R.id.team1)
            this.fixtureTeam2 = v.findViewById(R.id.team2)
            this.fixtureExtra = v.findViewById(R.id.extra)
            this.fixtureScore1 = v.findViewById(R.id.score1)
            this.fixtureScore2 = v.findViewById(R.id.score2)
            this.card_view = v.findViewById(R.id.card_view)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.fixture_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  fixureList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = fixureList!![position]
        holder.fixtureScore1!!.text = item.fixtureHomeTeamScore
        holder.fixtureScore2!!.text = item.fixtureAwayTeamScore
        holder.fixtureTeam1!!.text = item.fixtureHomeTeam
        holder.fixtureTeam2!!.text = item.fixtureAwayTeam
        Log.d("okh", "bind"+item.fixtureAwayTeam)
        holder.fixtureMD!!.text = item.fixtureID.toString()
        holder.fixtureStatus!!.text = item.fixtureStatus
        holder.fixtureExtra!!.text = item.fixtureID.toString()
        holder.card_view!!.setOnClickListener { listener(position, fixureList!!) }
    }


}

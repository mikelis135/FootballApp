package com.football.taiwo.football.Home.Competitions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.R

class CompetitionAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<CompetitionAdapter.MyViewHolder>() {

    var context : Context? = null
    private var competitionList : MutableList<CompetitionEntity>? = null
    lateinit var listener : (Int, MutableList<CompetitionEntity>) -> Unit


    constructor(context: Context?, competitionList: MutableList<CompetitionEntity>?, listener : (Int, MutableList<CompetitionEntity>) -> Unit) : this() {
        this.context = context
        this.competitionList = competitionList
        this.listener = listener
    }

    class MyViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {

        var competitioncompetition :  TextView? = null
        var card_view :  androidx.cardview.widget.CardView? = null

        init {
            this.competitioncompetition = v.findViewById(R.id.competitioncompetition)
            this.card_view = v.findViewById(R.id.card_view)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.competition_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  competitionList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = competitionList!!
        holder.competitioncompetition!!.text = item[position].competitionName
        holder.card_view!!.setOnClickListener { listener(position, competitionList!!) }
    }


}

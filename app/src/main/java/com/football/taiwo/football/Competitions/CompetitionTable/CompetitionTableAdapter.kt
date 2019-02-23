package com.football.taiwo.football.Competitions.CompetitionTable

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.football.taiwo.football.Database.Tables.TablesEntity
import com.football.taiwo.football.R

class CompetitionTableAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<CompetitionTableAdapter.MyViewHolder>() {

    var context : Context? = null
    var competitionTableList : MutableList<TablesEntity>? = null
    lateinit var listener : (Int, MutableList<TablesEntity>) -> Unit


    constructor(context: Context?, competitionTableList: MutableList<TablesEntity>?, listener : (Int, MutableList<TablesEntity>) -> Unit) : this() {
        this.context = context
        this.competitionTableList = competitionTableList
        this.listener = listener
    }

    class MyViewHolder : androidx.recyclerview.widget.RecyclerView.ViewHolder {

        var teamRank :  TextView? = null
        var teamLogo :  ImageView? = null
        var teamName :  TextView? = null
        var teamPoint1 :  TextView? = null
        var teamPoint2 :  TextView? = null
        var teamPoint3 :  TextView? = null
        var card_view :  androidx.cardview.widget.CardView? = null

         constructor(v: View) : super(v){
             this.teamRank = v.findViewById(R.id.teamRank)
             this.teamLogo = v.findViewById(R.id.teamLogo)
             this.teamName = v.findViewById(R.id.teamName)
             this.teamPoint1 = v.findViewById(R.id.teamPoint1)
             this.teamPoint2 = v.findViewById(R.id.teamPoint2)
             this.teamPoint3 = v.findViewById(R.id.teamPoint3)
             this.card_view = v.findViewById(R.id.card_view)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.competition_table_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  competitionTableList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = competitionTableList!!.get(position)
        holder.teamRank!!.text = item.tablesPosition
        Glide.with(context)
            .load(item.crestUrl)
            .thumbnail(0.5f)
            .override(200, 200)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.teamLogo)
        holder.teamName!!.text = item.name
        Log.d("okh", item.crestUrl+" from table adapter")
        holder.teamPoint1!!.text = item.playedGames
        holder.teamPoint2!!.text = item.goalsFor
        holder.teamPoint3!!.text = item.points
        holder.card_view!!.setOnClickListener { listener(position, competitionTableList!!) }
    }


}

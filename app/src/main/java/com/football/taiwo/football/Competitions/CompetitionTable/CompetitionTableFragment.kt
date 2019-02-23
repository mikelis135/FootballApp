package com.football.taiwo.football.Competitions.CompetitionTable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.football.taiwo.football.App
import com.football.taiwo.football.Competitions.Competition.Companion.competitionID
import com.football.taiwo.football.Database.Competition.CompetitionEntity
import com.football.taiwo.football.Database.Tables.TablesEntity
import com.football.taiwo.football.Home.CompetitionTableInteractor
import com.football.taiwo.football.Home.CompetitionTablePresenter
import com.football.taiwo.football.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_competition_table.*
import kotlinx.android.synthetic.main.fragment_competition_table.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CompetitionTableFragment : androidx.fragment.app.Fragment(), CompetitionTableView {

    override fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var rootView : View? = null
    private val competitionTablePresenter = CompetitionTablePresenter(competitionView = this, competitionInteractor = CompetitionTableInteractor())

    override fun stopShimmer() {

    }

    override fun onResume() {
        callTable()
       // CompetitionTableFragment.newInstance(competitionID)
        super.onResume()
    }

    override fun setTable(competitionId :  Int) {
        doAsync {
           var tablesList =   App.getInstance(context!!).tablesDao().allTables(competitionID)
            uiThread {

                 var tablesEntity : MutableList<TablesEntity> = ArrayList()
                for (football in 0 until tablesList.size) {
                    tablesEntity.add(football, tablesList.get(football))
                    Log.d("okh", tablesList.get(football).name+" from table fragment")

                    var tableAdapter = CompetitionTableAdapter(activity, tablesEntity, competitionTablePresenter::onCompetitionTableClicked)
                    rootView!!.competitionRecylerView.adapter = tableAdapter
                }

            }
        }
    }

    fun callTable(){
        doAsync {
            var tablesList =   App.getInstance(context!!).tablesDao().allTables(competitionID)
            uiThread {

                var tablesEntity : MutableList<TablesEntity> = ArrayList()
                for (football in 0 until tablesList.size) {
                    tablesEntity.add(football, tablesList.get(football))
                    Log.d("okh", tablesList.get(football).name+" from table fragment")

                    var tableAdapter = CompetitionTableAdapter(activity, tablesEntity, competitionTablePresenter::onCompetitionTableClicked)
                    rootView!!.competitionRecylerView.adapter = tableAdapter
                }

            }
        }
    }

    override fun showShimmer() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        rootView = inflater.inflate(R.layout.fragment_competition_table, container, false)
        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 1)
        rootView!!.competitionRecylerView.layoutManager = mLayoutManager
        Log.d("okh", competitionID.toString() + " fragment")
        competitionTablePresenter.loadTableCompetitions(competitionID)
        rootView!!.section_label.text = getString(
            R.string.section_format, arguments?.getInt(
                ARG_SECTION_NUMBER
            ))
        return rootView
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CompetitionTableFragment {
            val fragment = CompetitionTableFragment()

            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
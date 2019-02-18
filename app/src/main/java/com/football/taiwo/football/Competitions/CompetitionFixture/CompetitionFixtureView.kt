package com.football.taiwo.football.Competitions.CompetitionFixture

interface CompetitionFixtureView {
    fun showShimmer()
    fun stopShimmer()
    fun setFixture(items: MutableList<CompetitionFixtureModel>)
}
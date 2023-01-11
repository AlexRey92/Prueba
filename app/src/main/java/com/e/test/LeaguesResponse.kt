package com.e.test


data class LeaguesResponse (
val leagues:List<Leagues>
        )

data class Leagues (
    val idLeague:Int,
    val streLeague:String,
    val strSport:String,
    val strLeagueAlternate:String,
        )





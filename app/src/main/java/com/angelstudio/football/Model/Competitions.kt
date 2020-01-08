package com.angelstudio.football.Model


data class Competitions(
    val competitions: List<Competition>,
    val count: Int?,
    val filters: Filters?
)

data class Competition(
    val area: Area?,
    val code: String?,
    val currentSeason: CurrentSeason?,
    val emblemUrl: String?,
    val id: Int?,
    val lastUpdated: String?,
    val name: String?,
    val numberOfAvailableSeasons: Int?,
    val plan: String?
)

data class Area(
    val id: Int?,
    val name: String?
)

data class CurrentSeason(
    val currentMatchday: Int?,
    val endDate: String?,
    val id: Int?,
    val startDate: String?,
    val winner: Winner?
)

data class Winner(
    val crestUrl: String?,
    val id: Int?,
    val name: String?,
    val shortName: String?,
    val tla: String?
)

data class Filters(
    val plan: String?
)
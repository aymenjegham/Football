package com.angelstudio.football.Model

import java.io.Serializable


data class Competitions(
    val competitions: List<Competition>,
    val count: Int?,
    val filters: Filters?
):Serializable

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
):Serializable

data class Area(
    val id: Int?,
    val name: String?
):Serializable

data class CurrentSeason(
    val currentMatchday: Int?,
    val endDate: String?,
    val id: Int?,
    val startDate: String?,
    val winner: Winner?
):Serializable

data class Winner(
    val crestUrl: String?,
    val id: Int?,
    val name: String?,
    val shortName: String?,
    val tla: String?
):Serializable

data class Filters(
    val plan: String?
):Serializable
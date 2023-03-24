package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Investment(
    val id: Int,
    val value: Double,
    val dividend: Boolean,
    val date: Date
)

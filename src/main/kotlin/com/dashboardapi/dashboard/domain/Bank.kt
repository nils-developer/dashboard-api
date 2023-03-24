package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Bank(
    val id: Int,
    val value: Double,
    val date: Date
)
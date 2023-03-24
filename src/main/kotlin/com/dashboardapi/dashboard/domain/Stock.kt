package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Stock(
    val id: Int,
    val name: String,
    val price: Double,
    val date: Date
)

package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Stock(
    val id: Int,
    val stockName: String,
    val stockPrice: Double,
    val stockDate: Date
)

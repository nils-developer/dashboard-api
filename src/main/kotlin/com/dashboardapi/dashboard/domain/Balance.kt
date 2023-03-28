package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Balance(
    val balanceId: Int,
    val balance: Double,
    val date: Date?,
    val userId: Int
)


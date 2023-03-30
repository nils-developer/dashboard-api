package com.dashboardapi.dashboard.domain

import java.sql.Date

data class Transaction(
    val transactionId: Int,
    val transactionType: String,
    val amount: Double,
    val date: Date?,
    val userId: Int
)

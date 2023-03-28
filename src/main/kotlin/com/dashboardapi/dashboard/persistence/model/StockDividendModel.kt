package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*

@Entity(name = "stockDividends")
data class StockDividendModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val dividendId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_name")
    val stockName: StockModel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userId: UserModel
)

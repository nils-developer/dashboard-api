package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import java.util.Date

@Entity(name = "stockPurchases")
data class StockPurchaseModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val purchaseId: Int,

    @Column(name = "shares", columnDefinition = "double")
    val shares: Double,

    @Column(name = "purchase_price", columnDefinition = "double")
    val purchaseDate: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_name")
    val stockName: StockModel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userId: UserModel
)

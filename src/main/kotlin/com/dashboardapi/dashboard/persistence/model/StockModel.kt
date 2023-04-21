package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.sql.Date

@Entity(name = "stocks")
data class StockModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "stock_name", columnDefinition = "varChar(255)")
    val stockName: String,

    @Column(name = "price", columnDefinition = "double")
    val stockPrice: Double,

    @Column(name = "updated_at", columnDefinition = "date")
    @NotNull
    val stockDate: Date,

    @OneToMany(mappedBy = "purchaseId", cascade = [CascadeType.ALL])
    val stockPurchases: List<StockPurchaseModel> = emptyList()
)

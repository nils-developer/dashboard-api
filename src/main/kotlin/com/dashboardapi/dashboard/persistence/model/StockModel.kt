package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull
import java.sql.Date

@Entity(name = "stock")
data class StockModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name", columnDefinition = "varChar(255)")
    val name: String,

    @Column(name = "price", columnDefinition = "double")
    val price: Double,

    @Column(name = "updated_at", columnDefinition = "date")
    @NotNull
    val date: Date
)

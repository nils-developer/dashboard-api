package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.sql.Date

@Entity(name = "bank")
data class BankModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "value", columnDefinition = "double")
    val value: Double,

    @Column(name = "created_at", columnDefinition = "date")
    @NotNull
    val date: Date
)
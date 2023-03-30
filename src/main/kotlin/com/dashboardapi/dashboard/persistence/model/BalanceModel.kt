package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.sql.Date

@Entity(name = "balances")
data class BalanceModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val balanceId: Int,

    @Column(name = "balance", columnDefinition = "double")
    var balance: Double,

    @Column(name = "created_at", columnDefinition = "date")
    @NotNull
    var date: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserModel
)
package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.sql.Date

@Entity(name = "transactions")
data class TransactionModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val transactionId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userId: UserModel,

    @Column(name = "transaction_type", columnDefinition = "varChar(40)")
    val transactionType: String,

    @Column(name = "amount", columnDefinition = "double")
    val amount: Double,

    @Column(name = "created_at", columnDefinition = "date")
    @NotNull
    val date: Date
)

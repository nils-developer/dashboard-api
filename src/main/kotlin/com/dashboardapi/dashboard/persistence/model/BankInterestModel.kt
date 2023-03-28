package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*
import java.util.Date

@Entity(name = "bankInterests")
data class BankInterestModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val interestId: Int,

    @Column(name = "interest_value", columnDefinition = "double")
    val interestValue: Double,

    @Column(name = "interest_date", columnDefinition = "date")
    val interestDate: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userId: UserModel
)

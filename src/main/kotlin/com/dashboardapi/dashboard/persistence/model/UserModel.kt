package com.dashboardapi.dashboard.persistence.model

import jakarta.persistence.*

@Entity(name = "users")
data class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int,

    @Column(name = "username", columnDefinition = "varChar(50)")
    val username: String,

    @OneToMany(mappedBy = "userId", cascade = [CascadeType.ALL])
    val balances: List<BalanceModel> = emptyList(),

    @OneToMany(mappedBy = "userId", cascade = [CascadeType.ALL])
    val transactions: List<TransactionModel> = emptyList(),

    @OneToMany(mappedBy = "userId", cascade = [CascadeType.ALL])
    val dividends: List<StockDividendModel> = emptyList(),

    @OneToMany(mappedBy = "userId", cascade = [CascadeType.ALL])
    val interests: List<BankInterestModel> = emptyList()
)

package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.TransactionModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository: JpaRepository<TransactionModel, Int> {

    @Query(
        "SELECT * FROM transactions WHERE transaction_type = :type",
        nativeQuery = true
    )
    fun findAllTransactionsByType(type: String): List<TransactionModel>
}
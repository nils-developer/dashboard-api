package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Transaction
import com.dashboardapi.dashboard.persistence.model.TransactionModel
import com.dashboardapi.dashboard.persistence.repository.TransactionRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/transaction")
class TransactionsController(
    val transactionRepository: TransactionRepository
) {

    @GetMapping("/fetch")
    fun fetchAll(): List<Transaction> {
        return transactionRepository.findAll().map {
            Transaction(it.transactionId, it.transactionType, it.amount, it.date, it.user.userId)
        }
    }

    @PostMapping("/create")
    fun createTransaction(@RequestBody transactionModel: TransactionModel) {
        transactionRepository.save(transactionModel)
    }
}
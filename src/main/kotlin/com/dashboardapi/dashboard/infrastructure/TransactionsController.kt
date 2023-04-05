package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Transaction
import com.dashboardapi.dashboard.persistence.model.TransactionModel
import com.dashboardapi.dashboard.persistence.repository.TransactionRepository
import org.springframework.web.bind.annotation.*

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

    @DeleteMapping("/delete/{id}")
    fun deleteItem(@PathVariable id: Int)
    {
        transactionRepository.deleteById(id)
    }
}
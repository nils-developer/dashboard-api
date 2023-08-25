package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Amount
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

    @GetMapping("/fetchAll")
    fun fetchAll(): List<Transaction> = transactionRepository.findAll().map {
            Transaction(it.transactionId, it.transactionType, it.amount, it.date, it.user.userId)
        }

    @GetMapping("/fetchTotal")
    fun fetchTotal(): Amount {
        val totalExpense = transactionRepository.findAllTransactionByType("E").sumOf { it.amount }
        val totalBank = transactionRepository.findAllTransactionByType("B").sumOf { it.amount }
        val totalInvest = transactionRepository.findAllTransactionByType("I").sumOf{ it.amount }

        return Amount(totalBank + totalInvest - totalExpense)
    }

    @GetMapping("/fetchInvest")
    fun fetchInvest() = Amount(transactionRepository.findAllTransactionByType("I").sumOf { it.amount })

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
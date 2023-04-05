package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Balance
import com.dashboardapi.dashboard.persistence.model.BalanceModel
import com.dashboardapi.dashboard.persistence.repository.BalanceRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/balance")
class BalanceController(
    val balanceRepository: BalanceRepository
) {
    @GetMapping("/fetchAll")
    fun fetchAllFromBalance(): List<Balance> {
        return balanceRepository.findAll().map {
            Balance(it.balanceId, it.balance, it.date, it.user.userId)
        }
    }

    @GetMapping("/fetchBalance")
    fun fetchBalance(): List<Double> {
        return balanceRepository.findAll().map {
            it.balance
        }
    }

    @PatchMapping("/increase/{id}")
    fun increaseBalance(
        @PathVariable id: Int,
        @RequestBody requestBody: BalanceUpdateRequest
    ) {
        val balance = requestBody.balance
        val date = requestBody.date
        val balanceItem: BalanceModel = balanceRepository.findById(id).get()
        balanceItem.balance += balance
        balanceItem.date = date
        balanceRepository.save(balanceItem)
    }

    @PatchMapping("/decrease/{id}")
    fun decreaseBalance(
        @PathVariable id: Int,
        @RequestBody requestBody: TransactionDeleteReqeust
    ) {
        val amount = requestBody.amount
        val balanceItem: BalanceModel = balanceRepository.findById(id).get()
        balanceItem.balance -= amount
        balanceRepository.save(balanceItem)

    }
}

data class BalanceUpdateRequest(
    val balance: Double,
    val date: java.sql.Date
)

data class TransactionDeleteReqeust(
    val amount: Double
)
package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Balance
import com.dashboardapi.dashboard.persistence.repository.BalanceRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}
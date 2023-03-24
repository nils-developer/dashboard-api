package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Investment
import com.dashboardapi.dashboard.persistence.repository.InvestmentRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InvestmentController(
    val investmentRepository: InvestmentRepository
) {

    @GetMapping("/investment")
    fun getAllFromInvestment() {
        investmentRepository.findAll().map {
            Investment(it.id, it.value, it.dividend, it.date)
        }
    }
}
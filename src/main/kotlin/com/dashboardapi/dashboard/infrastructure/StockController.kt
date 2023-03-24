package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Stock
import com.dashboardapi.dashboard.persistence.repository.StockRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class StockController(
    val stockRepository: StockRepository
) {

    @GetMapping("/stock")
    fun getAllFromStock() {
        stockRepository.findAll().map {
            Stock(it.id, it.name, it.price, it.date)
        }
    }
}
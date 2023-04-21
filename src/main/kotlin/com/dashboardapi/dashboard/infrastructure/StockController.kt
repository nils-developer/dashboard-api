package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Stock
import com.dashboardapi.dashboard.persistence.model.StockModel
import com.dashboardapi.dashboard.persistence.repository.StockRepository
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/stock")
class StockController(
    val stockRepository: StockRepository
) {

    @GetMapping("/fetch")
    fun fetchAll(): List<Stock> {
        return stockRepository.findAll().map {
            Stock(it.id, it.stockName, it.stockPrice, it.stockDate)
        }
    }

    @PostMapping("/create")
    fun createStock(@RequestBody stockModel: StockModel) {
        stockRepository.save(stockModel)
    }
}
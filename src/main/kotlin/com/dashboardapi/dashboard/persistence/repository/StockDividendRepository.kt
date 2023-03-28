package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.StockDividendModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockDividendRepository: JpaRepository<StockDividendModel, Int> {
}
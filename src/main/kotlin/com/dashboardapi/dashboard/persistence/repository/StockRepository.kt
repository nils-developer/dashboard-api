package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.StockModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository: JpaRepository<StockModel, Int> {
}
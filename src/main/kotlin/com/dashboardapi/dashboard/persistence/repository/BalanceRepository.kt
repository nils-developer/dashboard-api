package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.BalanceModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BalanceRepository: JpaRepository<BalanceModel, Int> {
}
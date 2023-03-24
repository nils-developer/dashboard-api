package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.InvestmentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvestmentRepository: JpaRepository<InvestmentModel, Int> {
}
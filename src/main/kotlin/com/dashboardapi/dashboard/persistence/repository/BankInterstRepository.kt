package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.BankInterestModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BankInterstRepository: JpaRepository<BankInterestModel, Int> {
}
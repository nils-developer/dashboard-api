package com.dashboardapi.dashboard.persistence.repository

import com.dashboardapi.dashboard.persistence.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Int> {
}
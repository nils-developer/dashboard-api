package com.dashboardapi.dashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DashboardApiApplication

fun main(args: Array<String>) {
	runApplication<DashboardApiApplication>(*args)
}

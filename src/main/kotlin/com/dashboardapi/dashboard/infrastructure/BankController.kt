package com.dashboardapi.dashboard.infrastructure

import com.dashboardapi.dashboard.domain.Bank
import com.dashboardapi.dashboard.persistence.model.BankModel
import com.dashboardapi.dashboard.persistence.repository.BankRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/bank")
class BankController(
    val bankRepository: BankRepository
) {

    @GetMapping("/fetchAll")
    fun getAll(): List<Bank> {
        return bankRepository.findAll().map {
            Bank(it.id, it.value, it.date)
        }
    }

    @GetMapping("/fetchTotal")
    fun getTotalBankValue(): Double {
        return bankRepository.findAll().sumOf { item -> item.value }
    }

    @PostMapping("/create")
    fun createNewBankItem(@RequestBody bankModel: BankModel) {
        bankRepository.save(bankModel)
    }
}
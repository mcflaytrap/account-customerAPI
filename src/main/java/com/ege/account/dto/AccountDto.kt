package com.ege.account.dto

import com.ege.account.model.Customer
import com.ege.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

class AccountDto (
        val id: String?,

        val balance: BigDecimal?,

        val creationTime: LocalDateTime?,

        val customer: AccountCustomerDto?,

        val transactions: Set<TransactionDto>?

        )
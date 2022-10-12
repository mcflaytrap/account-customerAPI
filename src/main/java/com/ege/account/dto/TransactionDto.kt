package com.ege.account.dto

import com.ege.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(


        val id: String?,
        val transactionType: TransactionType = TransactionType.INITIAL,
        val transactionAmount: BigDecimal?,
        val transactionDate: LocalDateTime?
)

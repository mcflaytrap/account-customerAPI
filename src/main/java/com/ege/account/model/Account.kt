package com.ege.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Currency
import javax.persistence.*
import javax.persistence.CascadeType



@Entity
data class Account(

        @Id
        @GeneratedValue(generator ="UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? ="",

        val balance:BigDecimal? = BigDecimal.ZERO,

        val creationTime: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="customer_id", nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val transaction: Set<Transaction> = HashSet()



) {
        constructor(customer: Customer, balance: BigDecimal,creationTime: LocalDateTime):this(
                "",
                customer = customer,
                balance = balance,
                creationTime = creationTime
        )

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (creationTime != other.creationTime) return false
                if (customer != other.customer) return false
                if (transaction != other.transaction) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + creationTime.hashCode()
                result = 31 * result + (customer?.hashCode() ?: 0)
                result = 31 * result + transaction.hashCode()
                return result
        }


}

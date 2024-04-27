package br.com.filipeneri.backend.dto

import br.com.filipeneri.backend.model.Customer
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

data class OrderDTO(
        var customerId: Long
)

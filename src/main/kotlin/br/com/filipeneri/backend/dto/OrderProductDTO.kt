package br.com.filipeneri.backend.dto

import br.com.filipeneri.backend.model.Customer
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.OrderProductId
import br.com.filipeneri.backend.model.Product
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

data class OrderProductDTO(
        var orderId: Long ,
        var productId: Long ,
        var quantity: Int,
        var createdAt: Date = Date()
)

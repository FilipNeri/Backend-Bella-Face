package br.com.filipeneri.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable
import java.util.*
@Embeddable
data class OrderProductId(
        @Column(name = "order_id")
        var orderId: Long? = null,

        @Column(name = "product_id")
        var productId: Long? = null
) : Serializable

@Entity
@Table(name = "order_product")
data class OrderProduct(
        @EmbeddedId
        var id: OrderProductId = OrderProductId(),

        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "order_id", insertable = false, updatable = false)
        var order: Order? = null,

        @ManyToOne
        @JoinColumn(name = "product_id", insertable = false, updatable = false)
        var product: Product? = null,

        @Column
        var quantity: Int = 0,

        @Column(name = "unit_price")
        var unitPrice: Double = 0.0,

        @Column(name = "total_price")
        var totalPrice: Double = 0.0,

        @Column(name = "created_at")
        var createdAt: Date = Date()
)
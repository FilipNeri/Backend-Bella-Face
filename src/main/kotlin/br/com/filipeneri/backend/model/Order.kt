package br.com.filipeneri.backend.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "\"order\"")
data class Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        var customer: Customer? = null,
        @Column(name = "total_order")
        var totalOrder: Double = 0.00,
        @Column(name = "created_at")
        var createdAt: Date = Date(),
        @Column(length = 255)
        var comments: String = "",

        ) {
    override fun toString(): String {
        return "Order(id=$id, totalOrder=$totalOrder, createdAt=$createdAt, comments='$comments')"
    }
}

package br.com.filipeneri.backend.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "product")
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(length = 255)
        var name: String = "",
        @Column(length = 100)
        var description: String = "",
        @Column
        var price: Double = 0.00,
        @Column
        var created: Date = Date()
)

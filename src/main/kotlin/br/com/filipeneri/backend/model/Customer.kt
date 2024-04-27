package br.com.filipeneri.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @Column
        var name: String = "",
        @Column
        var login: String = "",
        @Column
        var password: String = "",
        @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
        var orders: MutableList<Order> = mutableListOf()
)

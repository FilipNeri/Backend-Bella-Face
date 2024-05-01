package br.com.filipeneri.backend.repository

import br.com.filipeneri.backend.model.Customer
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long?> {
    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.totalOrder = 0.00 ORDER BY o.id DESC LIMIT 1")
    fun findLatestOrderWithTotalOrderZero(customerId: Long): Order?
}
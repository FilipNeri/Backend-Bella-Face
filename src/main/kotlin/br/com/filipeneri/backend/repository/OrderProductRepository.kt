package br.com.filipeneri.backend.repository

import br.com.filipeneri.backend.model.Customer
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.OrderProduct
import br.com.filipeneri.backend.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderProductRepository : JpaRepository<OrderProduct, Long?> {
    fun findByOrderIdAndProductId(order_id: Long, product_id: Long): OrderProduct?
    fun existsByOrderIdAndProductId(orderId: Long, productId: Long): Boolean
}
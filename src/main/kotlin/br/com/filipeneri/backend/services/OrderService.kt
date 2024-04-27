package br.com.filipeneri.backend.services

import br.com.filipeneri.backend.dto.CommentaryDTO
import br.com.filipeneri.backend.dto.OrderDTO
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.repository.CustomerRepository
import br.com.filipeneri.backend.repository.OrderRepository
import br.com.filipeneri.backend.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService {
    @Autowired
    private lateinit var orderRepository: OrderRepository
    @Autowired
    private lateinit var customerRepository: CustomerRepository
    fun create(orderDTO: OrderDTO) : Order{
        val customer = customerRepository.findById(orderDTO.customerId)
                .orElseThrow { NoSuchElementException("Customer not found with ID: ${orderDTO.customerId}") }
        var order = Order()
        order.customer = customer
        return orderRepository.save(order)
    }
    fun addCommentay(commentaryDTO: CommentaryDTO) : Order{
        var order = orderRepository.findById(commentaryDTO.orderId)
                .orElseThrow { NoSuchElementException("Order not found with ID: ${commentaryDTO.orderId}") }
        order.comments = commentaryDTO.commentary
        return orderRepository.save(order)
    }
}
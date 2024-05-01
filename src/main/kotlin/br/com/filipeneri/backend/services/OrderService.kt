package br.com.filipeneri.backend.services

import br.com.filipeneri.backend.dto.FinishOrderDTO
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

        var order = orderRepository.findLatestOrderWithTotalOrderZero(customer.id)
        if(order != null){
            return order
        }
        var newOrder = Order()
        newOrder.customer = customer
        return orderRepository.save(newOrder)
    }
    fun finishOrder(orderFinish: FinishOrderDTO) : Order{
        var order = orderRepository.findById(orderFinish.orderId)
                .orElseThrow { NoSuchElementException("Order not found with ID: ${orderFinish.orderId}") }
        order.comments = orderFinish.commentary
        order.totalOrder = orderFinish.totalOrder
        return orderRepository.save(order)
    }
}
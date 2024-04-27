package br.com.filipeneri.backend.services

import br.com.filipeneri.backend.dto.OrderProductDTO
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.OrderProduct
import br.com.filipeneri.backend.model.OrderProductId
import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.repository.OrderProductRepository
import br.com.filipeneri.backend.repository.OrderRepository
import br.com.filipeneri.backend.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class OrderProductService {
    @Autowired
    private lateinit var orderProductRepository: OrderProductRepository
    @Autowired
    private lateinit var orderRepository: OrderRepository
    @Autowired
    private lateinit var productRepository: ProductRepository

    fun create(orderProductDTO: OrderProductDTO) : OrderProduct {
        val product = productRepository.findById(orderProductDTO.productId)
                .orElseThrow { NoSuchElementException("Product not found with ID: ${orderProductDTO.productId}") }
        val order = orderRepository.findById(orderProductDTO.orderId)
                .orElseThrow { NoSuchElementException("Order not found with ID: ${orderProductDTO.orderId}") }

        val orderProductId = OrderProductId(productId = product.id!!, orderId = order.id!!)

        var orderProduct = OrderProduct(
                id = orderProductId,
                product = product,
                order = order,
                quantity = orderProductDTO.quantity,
                unitPrice = product.price,
                totalPrice = product.price * orderProductDTO.quantity
        )

        return orderProductRepository.save(orderProduct)
    }
    fun update(orderProductDTO: OrderProductDTO): OrderProduct {

        val existingEntity = orderProductRepository.findByOrderIdAndProductId(orderProductDTO.orderId, orderProductDTO.productId)
                ?: throw NoSuchElementException("Entidade não encontrada para orderId=${orderProductDTO.orderId} e productId=${orderProductDTO.productId}")

        val product = productRepository.findById(orderProductDTO.productId)
                .orElseThrow { NoSuchElementException("Produto não encontrado com ID: ${orderProductDTO.productId}") }
        val order = orderRepository.findById(orderProductDTO.orderId)
                .orElseThrow { NoSuchElementException("Ordem não encontrada com ID: ${orderProductDTO.orderId}") }
        existingEntity.apply {
            this.product = product
            this.order = order
            this.quantity = orderProductDTO.quantity
            this.unitPrice = product.price
            this.totalPrice = product.price * orderProductDTO.quantity
        }
        return orderProductRepository.save(existingEntity)
    }
    fun deleteId(orderId: Long, productId:Long) {
        val entity = orderProductRepository.findByOrderIdAndProductId(orderId,productId)
        if (entity != null) {
            orderProductRepository.delete(entity)
        }else{
            throw ChangeSetPersister.NotFoundException()
        }
    }
    fun deleteAll(){
        orderProductRepository.deleteAll()
    }

}
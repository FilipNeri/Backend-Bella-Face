package br.com.filipeneri.backend.controller


import br.com.filipeneri.backend.dto.FinishOrderDTO
import br.com.filipeneri.backend.dto.OrderDTO
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.services.OrderService
import br.com.filipeneri.backend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {
    @Autowired
    private lateinit var service: OrderService

    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody order: OrderDTO): Order {
        return service.create(order)
    }

    @RequestMapping(
            value = ["/finish-order"],
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun finishOrder(@RequestBody order: FinishOrderDTO): Order {
        return service.finishOrder(order)
    }
}
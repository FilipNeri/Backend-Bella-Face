package br.com.filipeneri.backend.controller

import br.com.filipeneri.backend.dto.OrderDTO
import br.com.filipeneri.backend.dto.OrderProductDTO
import br.com.filipeneri.backend.model.Order
import br.com.filipeneri.backend.model.OrderProduct
import br.com.filipeneri.backend.model.OrderProductId
import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.services.OrderProductService
import br.com.filipeneri.backend.services.OrderService
import br.com.filipeneri.backend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order-product")
class OrderProductController {
    @Autowired//this annotation will inject the instance when necessary
    private lateinit var service: OrderProductService

    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody orderProductDTO: OrderProductDTO): OrderProduct {
        return service.create(orderProductDTO)
    }
    @RequestMapping(
            method = [RequestMethod.PUT],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody orderProductDTO: OrderProductDTO): OrderProduct {
        return service.update(orderProductDTO)
    }
    @RequestMapping(value = ["/{order}/{product}"], method = [RequestMethod.DELETE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(
            @PathVariable(value = "order") orderId: Long,
            @PathVariable(value = "product") productId: Long,
    ){
        service.deleteId(orderId,productId)
    }

    @RequestMapping(method = [RequestMethod.DELETE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(){
        service.deleteAll()
    }
}
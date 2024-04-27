package br.com.filipeneri.backend.controller

import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired//this annotation will inject the instance when necessary
    private lateinit var service: ProductService

    @RequestMapping( method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Product> {
        return service.findAll()
    }
}
package br.com.filipeneri.backend.services

import br.com.filipeneri.backend.model.Product
import br.com.filipeneri.backend.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    private lateinit var repository:ProductRepository

    fun findAll(): List<Product> {
        return repository.findAll()
    }
}
package br.com.filipeneri.backend.repository

import br.com.filipeneri.backend.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product,Long?>{
}
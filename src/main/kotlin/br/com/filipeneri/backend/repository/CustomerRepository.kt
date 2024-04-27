package br.com.filipeneri.backend.repository

import br.com.filipeneri.backend.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long?> {
    fun findByLoginAndPassword(login: String,password:String): Customer?
}
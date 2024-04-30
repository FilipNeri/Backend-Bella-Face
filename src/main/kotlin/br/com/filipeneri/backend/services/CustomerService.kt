package br.com.filipeneri.backend.services

import br.com.filipeneri.backend.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    private lateinit var repository: CustomerRepository

    fun validate(login: String, password: String): Long {
        val customer = repository.findByLoginAndPassword(login, password)
        if (customer != null) {
            return customer.id
        }
        return -1
    }
}
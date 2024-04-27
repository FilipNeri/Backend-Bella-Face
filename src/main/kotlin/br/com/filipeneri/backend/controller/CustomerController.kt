package br.com.filipeneri.backend.controller

import br.com.filipeneri.backend.dto.LoginDTO
import br.com.filipeneri.backend.services.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {
    @Autowired//this annotation will inject the instance when necessary
    private lateinit var service: CustomerService
    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody loginDTO: LoginDTO): Boolean {
        return service.validate(loginDTO.login,loginDTO.password)
    }
}
package br.com.filipeneri.backend.controller

import br.com.filipeneri.backend.dto.LoginDTO
import br.com.filipeneri.backend.services.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController {
    @Autowired//this annotation will inject the instance when necessary
    private lateinit var service: CustomerService
    @CrossOrigin
    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody loginDTO: LoginDTO): Long {
        return service.validate(loginDTO.login,loginDTO.password)
    }
}
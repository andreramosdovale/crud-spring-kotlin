package com.arv.project.controller

import com.arv.project.controller.request.PostCustomerRequest
import com.arv.project.controller.request.PutCustomerRequest
import com.arv.project.model.CustomerModel
import com.arv.project.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.findAll(name)
    }

    @GetMapping("/{id}")
    fun findByID(@PathVariable id: String): CustomerModel {
        return customerService.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest): CustomerModel {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody obj: PutCustomerRequest) {
        return customerService.update(id, obj)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        return customerService.delete(id)
    }
}
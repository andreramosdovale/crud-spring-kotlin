package com.arv.project.controller

import com.arv.project.controller.request.PostCustomerRequest
import com.arv.project.controller.request.PutCustomerRequest
import com.arv.project.extension.toCustomerModel
import com.arv.project.model.CustomerModel
import com.arv.project.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("customer")
class CustomerController(
    val service: CustomerService
) {
    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerModel> {
        return service.findAll(name)
    }

    @GetMapping("/{id}")
    fun findByID(@PathVariable id: Int): CustomerModel {
        return service.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        service.create(customer.toCustomerModel());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        return service.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        return service.delete(id)
    }
}
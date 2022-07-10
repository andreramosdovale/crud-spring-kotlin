package com.arv.project.controller

import com.arv.project.controller.request.PostCustomerRequest
import com.arv.project.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("customer")
class CustomerController {
    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun findAll(): List<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest): CustomerModel {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id + 1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))

        return customers.find { it.id == id }!!
    }
}
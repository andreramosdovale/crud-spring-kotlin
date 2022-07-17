package com.arv.project.service

import com.arv.project.controller.request.PostCustomerRequest
import com.arv.project.controller.request.PutCustomerRequest
import com.arv.project.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }

        return customers
    }

    fun findById(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun create(customer: PostCustomerRequest): CustomerModel {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id + 1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))

        return customers.find { it.id == id }!!
    }

    fun update(id: String, obj: PutCustomerRequest) {
        customers.first { it.id == id }.let {
            it.name = obj.name
            it.email = obj.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}
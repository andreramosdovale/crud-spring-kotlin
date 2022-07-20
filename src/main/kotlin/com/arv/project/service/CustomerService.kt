package com.arv.project.service

import com.arv.project.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }

        return customers
    }

    fun findById(id: Int): CustomerModel {
        return customers.first { it.id == id }
    }

    fun create(customer: CustomerModel): CustomerModel {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }

        customer.id = id

        customers.add(customer)

        return customers.find { it.id == id }!!
    }

    fun update(customer: CustomerModel) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: Int) {
        customers.removeIf { it.id == id }
    }
}
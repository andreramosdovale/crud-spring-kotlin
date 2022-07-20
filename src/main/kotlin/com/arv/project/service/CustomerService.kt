package com.arv.project.service

import com.arv.project.model.CustomerModel
import com.arv.project.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val repository: CustomerRepository
) {
    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return repository.findByNameContaining(it)
        }

        return repository.findAll().toList()
    }

    fun findById(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow()
    }

    fun create(customer: CustomerModel) {
        repository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if (!repository.existsById(customer.id!!)) {
            throw Exception()
        }

        repository.save(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            throw Exception()
        }

        repository.deleteById(id)
    }
}
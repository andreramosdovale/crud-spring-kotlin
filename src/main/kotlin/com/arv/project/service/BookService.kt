package com.arv.project.service

import com.arv.project.model.BookModel
import com.arv.project.model.CustomerModel
import com.arv.project.repository.BookRepository
import com.arv.project.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {
    fun create(book: BookModel) {
        repository.save(book)
    }
}
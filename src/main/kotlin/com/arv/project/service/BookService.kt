package com.arv.project.service

import com.arv.project.emuns.BookStatus
import com.arv.project.model.BookModel
import com.arv.project.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {
    fun create(book: BookModel) {
        repository.save(book)
    }

    fun findAll(): List<BookModel> {
        return repository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return repository.findByStatus(BookStatus.ATIVO)
    }
}
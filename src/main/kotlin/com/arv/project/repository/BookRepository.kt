package com.arv.project.repository

import com.arv.project.emuns.BookStatus
import com.arv.project.model.BookModel
import com.arv.project.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>

}
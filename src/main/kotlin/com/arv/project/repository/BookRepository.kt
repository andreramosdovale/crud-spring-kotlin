package com.arv.project.repository

import com.arv.project.model.BookModel
import com.arv.project.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
}
package com.arv.project.controller

import com.arv.project.controller.request.PostBookRequest
import com.arv.project.controller.request.PutBookRequest
import com.arv.project.extension.toBookModel
import com.arv.project.model.BookModel
import com.arv.project.service.BookService
import com.arv.project.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("book")
class BookController(
    val customerService: CustomerService,
    val service: BookService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: PostBookRequest) {
        val customer = customerService.findById(book.customeId)
        service.create(book.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return service.findAll()
    }

    @GetMapping("/actives")
    fun findActives(): List<BookModel> {
        return service.findActives()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel {
        return service.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        return service.delete(id)
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestParam obj: PutBookRequest) {
        val book = service.findById(id)
        return service.update(obj.toBookModel(book))
    }
}
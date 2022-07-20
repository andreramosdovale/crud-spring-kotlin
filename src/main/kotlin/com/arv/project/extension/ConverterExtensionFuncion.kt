package com.arv.project.extension

import com.arv.project.controller.request.PostCustomerRequest
import com.arv.project.controller.request.PutCustomerRequest
import com.arv.project.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
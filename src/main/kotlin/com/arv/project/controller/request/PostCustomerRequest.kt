package com.arv.project.controller.request

import com.arv.project.model.CustomerModel

data class PostCustomerRequest(
    var name: String,
    var email: String
)

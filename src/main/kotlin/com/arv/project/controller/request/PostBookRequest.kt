package com.arv.project.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest(
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customeId: Int
)

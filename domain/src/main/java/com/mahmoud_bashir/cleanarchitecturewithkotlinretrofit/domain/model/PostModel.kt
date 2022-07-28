package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model

import java.io.Serializable

data class PostModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
):Serializable
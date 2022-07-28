package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.repositories

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model.PostModel

interface PostsRepositoryI {
    suspend fun getPosts():MutableList<PostModel>?
}
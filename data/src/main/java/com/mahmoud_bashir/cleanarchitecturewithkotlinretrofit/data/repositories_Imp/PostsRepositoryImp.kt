package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.repositories_Imp

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.api_remote.ApiServiceInterface
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model.PostModel
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.repositories.PostsRepositoryI

class PostsRepositoryImp(private val apiServ:ApiServiceInterface): PostsRepositoryI {
    override suspend fun getPosts(): MutableList<PostModel>?=
        apiServ.getAllPosts().body()?.toList()
            ?.map { it.map(it) }?.toMutableList()
}
package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.api_remote

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("posts")
    suspend fun getAllPosts():Response<PostsResponse>
}
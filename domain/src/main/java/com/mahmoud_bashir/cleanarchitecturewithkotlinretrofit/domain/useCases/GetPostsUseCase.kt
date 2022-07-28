package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.useCases

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model.PostModel
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.repositories.PostsRepositoryI
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.result.Resource
import java.lang.Exception

class GetPostsUseCase(private val repo:PostsRepositoryI) {
    suspend operator fun invoke():Resource<MutableList<PostModel>?>
    {
        return try {
            val data = repo.getPosts()
            return Resource.Success(data)
        }catch (e:Exception){
            Resource.Error(e.message.toString(),null)
        }
    }
}
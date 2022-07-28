package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.model

import com.google.gson.annotations.SerializedName
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.mapper.Mapper
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model.PostModel

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
):Mapper<Post,PostModel>{
    override fun map(from: Post): PostModel = PostModel(
        body = body.toString(),
        id=id,
        title=title,
        userId=userId
    )
}

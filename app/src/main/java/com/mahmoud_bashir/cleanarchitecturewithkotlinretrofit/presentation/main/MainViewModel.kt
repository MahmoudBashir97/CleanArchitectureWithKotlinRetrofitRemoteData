package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.model.Post
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.repositories_Imp.PostsRepositoryImp
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.model.PostModel
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.result.Resource
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.useCases.GetPostsUseCase
import kotlinx.coroutines.launch

class MainViewModel(app:Application,private val getPostsUseCase: GetPostsUseCase):AndroidViewModel(app){

    val postsList:MutableLiveData<Resource<MutableList<PostModel>?>> = MutableLiveData()

    init {
        getPosts()
    }

     fun getPosts()=viewModelScope.launch {

        postsList.postValue(getPostsUseCase.invoke())
    }
}
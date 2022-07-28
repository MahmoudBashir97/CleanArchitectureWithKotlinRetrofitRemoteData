package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.mapper

interface Mapper<in FROM, out TO> {
    fun map(from: FROM): TO
}
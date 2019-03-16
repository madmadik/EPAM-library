package kz.epamlibrary.network

import retrofit2.http.GET
import io.reactivex.Observable
import kz.epamlibrary.entity.UserResponse
import retrofit2.http.Url

interface ApiService {

    @GET
    fun fetchUsers(@Url url: String): Observable<UserResponse>
}

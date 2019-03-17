package kz.epamlibrary.network

import retrofit2.http.GET
import io.reactivex.Observable
import kz.epamlibrary.entity.Book
import kz.epamlibrary.entity.Category
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {

    @GET("http://10.3.27.146:8080/books/all")
    fun fetchBooks(): Observable<List<Book>>

    @GET("http://10.3.27.146:8080/categories/all")
    fun fetchCategories(): Observable<List<Category>>

    @GET("http://10.3.27.146:8080/books/{id}")
    fun fetchBooksByCategory(@Path("id") id: Int): Observable<List<Book>>
}

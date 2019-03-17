package kz.epamlibrary.entity

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("author")
    var author: String,
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("dateCreated")
    var dateCreated: Long,
    @SerializedName("dateModified")
    var dateModified: Long,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: Any,
    @SerializedName("title")
    var title: String
)

data class Category(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)
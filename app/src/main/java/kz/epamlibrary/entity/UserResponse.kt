package kz.epamlibrary.entity

import com.google.gson.annotations.SerializedName

class UserResponse {

    @SerializedName("results")
    var peopleList: List<User>? = null

}

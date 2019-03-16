package kz.epamlibrary.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class User : Serializable {

    @SerializedName("gender")
    var gender: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("phone")
    var phone: String? = null

    @SerializedName("cell")
    var cell: String? = null
}

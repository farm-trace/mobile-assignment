package org.takingroot.assignment.networking

import com.google.gson.annotations.SerializedName


data class APIResponse<T>(
    @SerializedName("total")
    val total: Int,
    @SerializedName("limit")
    val limit: Int,

    @SerializedName("skip")
    val skip: Int,

    @SerializedName("data")
    val data: List<T>,
)


data class UserResponse(
    @SerializedName("id")
    var id: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var last_name: String
)

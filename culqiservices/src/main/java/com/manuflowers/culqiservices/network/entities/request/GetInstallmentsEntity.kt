package com.manuflowers.culqiservices.network.entities.request

import com.google.gson.annotations.SerializedName

data class GetInstallmentsEntity(
    @SerializedName("bin")
    val bin: String
) {
    private constructor(builder: Builder) : this(
        builder.bin
    )

    class Builder {
        var bin: String = ""
            private set

        fun bin(bin: String) = apply {
            this.bin = bin
        }

        fun build() = GetInstallmentsEntity(this)
    }
}
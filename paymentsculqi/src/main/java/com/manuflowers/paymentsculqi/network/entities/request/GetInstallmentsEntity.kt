package com.manuflowers.paymentsculqi.network.entities.request

data class GetInstallmentsEntity(
    val bin :String
) {
    private constructor(builder: Builder): this(
        builder.bin
    )

    class Builder{
        var bin : String = ""
        private set

        fun bin(bin: String) = apply {
            this.bin = bin
        }

        fun build() = GetInstallmentsEntity(this)
    }
}
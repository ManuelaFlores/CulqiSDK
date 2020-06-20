package com.manuflowers.culqiservices.network.entities.request

import com.google.gson.annotations.SerializedName

data class GetTokenEntity(
    @SerializedName("card_number")
    val card_number: String,
    @SerializedName("cvv")
    val cvv: String,
    @SerializedName("expiration_month")
    val expiration_month: String,
    @SerializedName("expiration_year")
    val expiration_year: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("metadata")
    val metadata: Metadata
) {
    private constructor(builder: Builder) : this(
        builder.cardNumber,
        builder.cvv,
        builder.expirationMonth,
        builder.expirationYear,
        builder.email,
        builder.metadata
    )

    class Builder {
        var cardNumber: String = ""
            private set

        var cvv: String = ""
            private set

        var expirationMonth: String = ""
            private set

        var expirationYear: String = ""
            private set

        var email: String = ""
            private set

        var metadata: Metadata = Metadata("", "")
            private set

        fun card(
            cardNumber: String,
            cvv: String,
            expirationMonth: String,
            expirationYear: String,
            email: String,
            metadata: Metadata
        ) = apply {
            this.cardNumber = cardNumber
            this.cvv = cvv
            this.expirationMonth = expirationMonth
            this.expirationYear = expirationYear
            this.email = email
            this.metadata = metadata
        }

        fun build() = GetTokenEntity(this)
    }
}

data class Metadata(
    @SerializedName("account_holder_firstname")
    val account_holder_firstname: String,
    @SerializedName("account_holder_lastname")
    val account_holder_lastname: String) {

    private constructor(builder: Builder) : this(
        builder.accountHolderName,
        builder.accountHolderLastName
    )

    class Builder {

        var accountHolderName: String = ""
            private set

        var accountHolderLastName: String = ""

        fun accountHolderName(accountHolderName: String) = apply {
            this.accountHolderName = accountHolderName
        }

        fun accountHolderLastName(accountHolderLastName: String) = apply {
            this.accountHolderLastName = accountHolderLastName
        }

        fun build() = Metadata(this)
    }
}
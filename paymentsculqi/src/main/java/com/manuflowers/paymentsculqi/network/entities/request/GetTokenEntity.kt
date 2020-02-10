package com.manuflowers.paymentsculqi.network.entities.request

data class GetTokenEntity(
    val card_number: String,
    val cvv: String,
    val expiration_month: String,
    val expiration_year: String,
    val email: String,
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

        var metadata: Metadata = Metadata("")
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

data class Metadata(val account_holder_name: String) {

    private constructor(builder: Builder) : this(
        builder.accountHolderName
    )

    class Builder {

        var accountHolderName: String = ""
            private set

        fun accountHolderName(accountHolderName: String) = apply {
            this.accountHolderName = accountHolderName
        }

        fun build() = Metadata(this)
    }
}
package ir.irezaa.cryptoprice.root.token.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Token(val name: String, val value: Double)

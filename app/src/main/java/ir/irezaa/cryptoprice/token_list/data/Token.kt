package ir.irezaa.cryptoprice.token_list.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Token(val name: String, val value: Double)

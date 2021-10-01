package ir.irezaa.cryptoprice.root.token.data.response

import com.squareup.moshi.JsonClass
import ir.irezaa.cryptoprice.root.token.data.Token

@JsonClass(generateAdapter = true)
data class GetTokenListResponse(val rates : Map<String,Token>)
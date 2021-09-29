package ir.irezaa.cryptoprice.token_list.data.response

import com.squareup.moshi.JsonClass
import ir.irezaa.cryptoprice.token_list.data.Token

@JsonClass(generateAdapter = true)
data class GetTokenListResponse(val rates : Map<String,Token>)
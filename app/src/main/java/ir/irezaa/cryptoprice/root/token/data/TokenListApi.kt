package ir.irezaa.cryptoprice.root.token.data

import ir.irezaa.cryptoprice.root.token.data.response.GetTokenListResponse
import retrofit2.http.GET

interface TokenListApi {
    @GET("exchange_rates")
    suspend fun tokenList(): GetTokenListResponse
}
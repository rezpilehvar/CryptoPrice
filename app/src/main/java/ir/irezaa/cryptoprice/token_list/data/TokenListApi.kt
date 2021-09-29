package ir.irezaa.cryptoprice.token_list.data

import ir.irezaa.cryptoprice.token_list.data.response.GetTokenListResponse
import retrofit2.http.GET

interface TokenListApi {
    @GET("exchange_rates")
    suspend fun tokenList(): GetTokenListResponse
}
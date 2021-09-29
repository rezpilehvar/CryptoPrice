package ir.irezaa.cryptoprice.token_list.data

import javax.inject.Inject

class TokenRepository @Inject constructor(private val tokenListApi: TokenListApi) {
    suspend fun getTokenList(): List<Token> {
        return tokenListApi.tokenList().rates.values.toList()
    }
}
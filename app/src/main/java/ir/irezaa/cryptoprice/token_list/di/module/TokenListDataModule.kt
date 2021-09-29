package ir.irezaa.cryptoprice.token_list.di.module

import dagger.Module
import dagger.Provides
import ir.irezaa.cryptoprice.token_list.data.TokenListApi
import retrofit2.Retrofit

@Module
interface TokenListDataModule {
    companion object {


        @Provides
        fun provideTokenListApi(retrofit: Retrofit): TokenListApi {
            return retrofit.create(TokenListApi::class.java)
        }
    }
}
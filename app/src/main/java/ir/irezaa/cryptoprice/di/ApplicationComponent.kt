package ir.irezaa.cryptoprice.di

import dagger.Component
import ir.irezaa.cryptoprice.token_list.TokenListBuilder

@Component
interface ApplicationComponent : TokenListBuilder.ParentComponent
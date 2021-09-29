package ir.irezaa.cryptoprice.di.component

import dagger.Component
import ir.irezaa.cryptoprice.di.module.NetworkModule
import ir.irezaa.cryptoprice.token_list.TokenListBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ApplicationComponent : TokenListBuilder.ParentComponent
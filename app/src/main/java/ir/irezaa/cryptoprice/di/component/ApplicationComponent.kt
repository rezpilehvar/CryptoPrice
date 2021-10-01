package ir.irezaa.cryptoprice.di.component

import dagger.Component
import ir.irezaa.cryptoprice.di.module.NetworkModule
import ir.irezaa.cryptoprice.root.RootBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ApplicationComponent : RootBuilder.ParentComponent
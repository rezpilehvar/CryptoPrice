package ir.irezaa.cryptoprice.root.token.item.di.component

import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.item.TokenItemInteractor
import ir.irezaa.cryptoprice.root.token.item.TokenItemView
import ir.irezaa.cryptoprice.root.token.item.di.module.TokenItemModule
import ir.irezaa.cryptoprice.root.token.item.di.scope.TokenItemScope
import ir.irezaa.cryptoprice.root.token.data.Token

@TokenItemScope
@dagger.Component(
    modules = [
        TokenItemModule::class
    ],
    dependencies = [
        TokenItemBuilder.ParentComponent::class
    ]
)
interface TokenItemComponent : InteractorBaseComponent<TokenItemInteractor>,
    TokenItemBuilder.BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: TokenItemInteractor): Builder

        @BindsInstance
        fun view(view: TokenItemView): Builder

        fun parentComponent(component: TokenItemBuilder.ParentComponent): Builder

        @BindsInstance
        fun token(token: Token) : Builder

        fun build(): TokenItemComponent
    }
}
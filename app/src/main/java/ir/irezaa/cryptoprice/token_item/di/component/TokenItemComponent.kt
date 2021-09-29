package ir.irezaa.cryptoprice.token_item.di.component

import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import ir.irezaa.cryptoprice.token_item.TokenItemBuilder
import ir.irezaa.cryptoprice.token_item.TokenItemInteractor
import ir.irezaa.cryptoprice.token_item.TokenItemView
import ir.irezaa.cryptoprice.token_item.di.module.TokenItemModule
import ir.irezaa.cryptoprice.token_item.di.scope.TokenItemScope

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
        fun build(): TokenItemComponent
    }
}
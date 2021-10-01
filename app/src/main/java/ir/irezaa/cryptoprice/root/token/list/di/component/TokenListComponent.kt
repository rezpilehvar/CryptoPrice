package ir.irezaa.cryptoprice.root.token.list.di.component

import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import ir.irezaa.cryptoprice.root.token.list.di.scope.TokenListScope
import dagger.Component
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListInteractor
import ir.irezaa.cryptoprice.root.token.list.view.TokenListView
import ir.irezaa.cryptoprice.root.token.list.di.module.TokenListModule

@TokenListScope
@Component(
    modules = [
        TokenListModule::class
    ],
    dependencies = [
        TokenListBuilder.ParentComponent::class
    ]
)
interface TokenListComponent : InteractorBaseComponent<TokenListInteractor>,
    TokenListBuilder.BuilderComponent, TokenItemBuilder.ParentComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: TokenListInteractor): Builder

        @BindsInstance
        fun view(view: TokenListView): Builder

        fun parentComponent(component: TokenListBuilder.ParentComponent): Builder
        fun build(): TokenListComponent
    }
}
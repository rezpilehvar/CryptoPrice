package ir.irezaa.cryptoprice.token_list.di.component

import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import ir.irezaa.cryptoprice.token_list.di.scope.TokenListScope
import dagger.Component
import ir.irezaa.cryptoprice.token_list.TokenListBuilder
import ir.irezaa.cryptoprice.token_list.TokenListInteractor
import ir.irezaa.cryptoprice.token_list.di.module.TokenListDataModule
import ir.irezaa.cryptoprice.token_list.view.TokenListView
import ir.irezaa.cryptoprice.token_list.di.module.TokenListModule

@TokenListScope
@Component(
    modules = [
        TokenListModule::class,
        TokenListDataModule::class
    ],
    dependencies = [
        TokenListBuilder.ParentComponent::class
    ]
)
interface TokenListComponent : InteractorBaseComponent<TokenListInteractor>,
    TokenListBuilder.BuilderComponent {

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
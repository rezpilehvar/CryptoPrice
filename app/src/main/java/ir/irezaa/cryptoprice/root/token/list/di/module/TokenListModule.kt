package ir.irezaa.cryptoprice.root.token.list.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListInteractor
import ir.irezaa.cryptoprice.root.token.list.TokenListRouter
import ir.irezaa.cryptoprice.root.token.list.view.TokenListView
import ir.irezaa.cryptoprice.root.token.list.di.component.TokenListComponent
import ir.irezaa.cryptoprice.root.token.list.di.scope.TokenListScope

@Module
internal abstract class TokenListModule {

    @TokenListScope
    @Binds
    internal abstract fun presenter(view: TokenListView): TokenListInteractor.TokenListPresenter

    @dagger.Module
    companion object {

        @TokenListScope
        @Provides
        internal fun router(
            component: TokenListComponent,
            view: TokenListView,
            interactor: TokenListInteractor
        ): TokenListRouter {
            return TokenListRouter(view, interactor, component, TokenItemBuilder(component))
        }
    }

}
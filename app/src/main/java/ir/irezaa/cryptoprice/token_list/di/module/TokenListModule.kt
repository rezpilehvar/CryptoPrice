package ir.irezaa.cryptoprice.token_list.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import ir.irezaa.cryptoprice.token_list.TokenListInteractor
import ir.irezaa.cryptoprice.token_list.TokenListRouter
import ir.irezaa.cryptoprice.token_list.view.TokenListView
import ir.irezaa.cryptoprice.token_list.di.component.TokenListComponent
import ir.irezaa.cryptoprice.token_list.di.scope.TokenListScope

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
            return TokenListRouter(view, interactor, component)
        }
    }

}
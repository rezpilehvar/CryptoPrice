package ir.irezaa.cryptoprice.root.token.item.di.module

import dagger.Binds
import dagger.Provides
import ir.irezaa.cryptoprice.root.token.item.TokenItemInteractor
import ir.irezaa.cryptoprice.root.token.item.TokenItemRouter
import ir.irezaa.cryptoprice.root.token.item.TokenItemView
import ir.irezaa.cryptoprice.root.token.item.di.component.TokenItemComponent
import ir.irezaa.cryptoprice.root.token.item.di.scope.TokenItemScope

@dagger.Module
abstract class TokenItemModule {

    @TokenItemScope
    @Binds
    internal abstract fun presenter(view: TokenItemView): TokenItemInteractor.TokenItemPresenter

    @dagger.Module
    companion object {

        @TokenItemScope
        @Provides
        @JvmStatic
        internal fun router(
            component: TokenItemComponent,
            view: TokenItemView,
            interactor: TokenItemInteractor
        ): TokenItemRouter {
            return TokenItemRouter(view, interactor, component)
        }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
}
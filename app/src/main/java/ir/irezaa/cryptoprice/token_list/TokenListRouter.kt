package ir.irezaa.cryptoprice.token_list

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.token_list.di.component.TokenListComponent


class TokenListRouter(
    view: TokenListView,
    interactor: TokenListInteractor,
    component: TokenListComponent
) : ViewRouter<TokenListView, TokenListInteractor>(view, interactor, component)

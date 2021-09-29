package ir.irezaa.cryptoprice.token_item

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.token_item.di.component.TokenItemComponent


class TokenItemRouter(
    view: TokenItemView,
    interactor: TokenItemInteractor,
    component: TokenItemComponent
) : ViewRouter<TokenItemView, TokenItemInteractor>(view, interactor, component)

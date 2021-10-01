package ir.irezaa.cryptoprice.root.token.item

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.root.token.item.di.component.TokenItemComponent


class TokenItemRouter(
    view: TokenItemView,
    interactor: TokenItemInteractor,
    component: TokenItemComponent
) : ViewRouter<TokenItemView, TokenItemInteractor>(view, interactor, component)

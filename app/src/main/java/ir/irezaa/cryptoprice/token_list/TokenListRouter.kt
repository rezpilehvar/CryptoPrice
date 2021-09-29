package ir.irezaa.cryptoprice.token_list

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.token_list.data.Token
import ir.irezaa.cryptoprice.token_list.di.component.TokenListComponent
import ir.irezaa.cryptoprice.token_list.view.TokenListView


class TokenListRouter(
    view: TokenListView,
    interactor: TokenListInteractor,
    component: TokenListComponent
) : ViewRouter<TokenListView, TokenListInteractor>(view, interactor, component) {


    fun presentTokenItem(token : Token) {

    }
}

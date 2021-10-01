package ir.irezaa.cryptoprice.root.token.list

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.item.TokenItemRouter
import ir.irezaa.cryptoprice.root.token.data.Token
import ir.irezaa.cryptoprice.root.token.list.di.component.TokenListComponent
import ir.irezaa.cryptoprice.root.token.list.view.TokenListView


class TokenListRouter(
    view: TokenListView,
    interactor: TokenListInteractor,
    component: TokenListComponent,
    private val tokenItemBuilder: TokenItemBuilder,
) : ViewRouter<TokenListView, TokenListInteractor>(view, interactor, component) {

    private var tokenItemRouter: TokenItemRouter? = null

    fun attachTokenItem(token : Token) {
        tokenItemRouter = tokenItemBuilder.build(view,token)

        tokenItemRouter?.let {
            attachChild(it)
            view.addView(it.view)
        }
    }

    private fun detachTokenItem() {
        tokenItemRouter?.let {
            detachChild(it)
            view.removeView(it.view)
            tokenItemRouter = null
        }
    }

    override fun willDetach() {
        super.willDetach()
        detachTokenItem()
    }
}

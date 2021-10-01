package ir.irezaa.cryptoprice.root.token

import android.view.ViewGroup
import com.uber.rib.core.Router
import ir.irezaa.cryptoprice.root.token.data.Token
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.item.TokenItemRouter
import ir.irezaa.cryptoprice.root.token.list.TokenListBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListRouter


class TokenRouter(
    private val parentView: ViewGroup,
    interactor: TokenInteractor,
    component: TokenBuilder.Component,
    private val tokenListBuilder: TokenListBuilder,
    private val tokenItemBuilder: TokenItemBuilder,
) : Router<TokenInteractor>(interactor, component) {

    private var tokenListRouter: TokenListRouter? = null
    private var tokenItemRouter: TokenItemRouter? = null

    fun attachTokenList() {
        tokenListRouter = tokenListBuilder.build(parentView)

        attachChild(tokenListRouter!!)
        parentView.addView(tokenListRouter!!.view)
    }

    private fun detachTokenList() {
        tokenListRouter?.let {
            detachChild(it)
            parentView.removeView(it.view)
            tokenListRouter = null
        }
    }

    fun attachTokenItem(token: Token) {
        tokenItemRouter = tokenItemBuilder.build(parentView, token)

        attachChild(tokenItemRouter!!)
        parentView.addView(tokenItemRouter!!.view)
    }

    private fun detachTokenItem() {
        tokenItemRouter?.let {
            detachChild(it)
            parentView.removeView(it.view)
            tokenItemRouter = null
        }
    }

    override fun willDetach() {
        super.willDetach()
        detachTokenList()
        detachTokenItem()
    }

    override fun handleBackPress(): Boolean {
        if (tokenItemRouter != null) {
            detachTokenItem()
            return true
        }
        return false
    }
}

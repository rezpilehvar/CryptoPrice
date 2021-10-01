package ir.irezaa.cryptoprice.root

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.root.token.TokenBuilder
import ir.irezaa.cryptoprice.root.token.TokenRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val tokenBuilder: TokenBuilder,
) : ViewRouter<RootView, RootInteractor>(view, interactor, component) {

    private var tokenRouter: TokenRouter? = null

    fun attachToken() {
        tokenRouter = tokenBuilder.build()
        attachChild(tokenRouter!!)
    }

    override fun handleBackPress(): Boolean {
        return tokenRouter?.handleBackPress() == true
    }
}

package ir.irezaa.cryptoprice.root

import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.root.token.TokenBuilder
import ir.irezaa.cryptoprice.root.token.TokenRouter
import ir.irezaa.cryptoprice.root.toolbar.ToolbarBuilder
import ir.irezaa.cryptoprice.root.toolbar.ToolbarRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val toolbarBuilder: ToolbarBuilder,
    private val tokenBuilder: TokenBuilder,
) : ViewRouter<RootView, RootInteractor>(view, interactor, component) {

    private val toolbarRouter = toolbarBuilder.build(view)
    private val tokenRouter = tokenBuilder.build()

    fun attachToolbar() {
        attachChild(toolbarRouter)
        view.addView(toolbarRouter.view)
    }

    fun attachToken() {
        attachChild(tokenRouter)
    }

    override fun handleBackPress(): Boolean {
        return tokenRouter.handleBackPress()
    }
}

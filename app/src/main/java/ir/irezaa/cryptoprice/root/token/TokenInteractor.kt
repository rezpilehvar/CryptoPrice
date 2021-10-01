package ir.irezaa.cryptoprice.root.token

import com.uber.rib.core.Bundle
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import com.uber.rib.core.Router
import ir.irezaa.cryptoprice.root.token.data.Token
import ir.irezaa.cryptoprice.root.token.list.TokenListInteractor

import javax.inject.Inject


@RibInteractor
class TokenInteractor : Interactor<EmptyPresenter, TokenRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        router.attachTokenList()
    }

    override fun willResignActive() {
        super.willResignActive()

    }

    inner class TokenPreviewRequestListener : TokenListInteractor.Listener {
        override fun requestTokenPreview(token: Token) {
            router.attachTokenItem(token)
        }
    }
}

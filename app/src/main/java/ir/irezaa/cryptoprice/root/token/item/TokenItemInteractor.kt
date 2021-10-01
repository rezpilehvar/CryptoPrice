package ir.irezaa.cryptoprice.root.token.item

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import ir.irezaa.cryptoprice.root.token.data.Token
import javax.inject.Inject


@RibInteractor
class TokenItemInteractor : Interactor<TokenItemInteractor.TokenItemPresenter, TokenItemRouter>() {

    @Inject
    lateinit var presenter: TokenItemPresenter

    @Inject
    lateinit var token: Token

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        presenter.setTokenTitle(token.name)
    }

    override fun willResignActive() {
        super.willResignActive()

    }


    interface TokenItemPresenter {
        fun setTokenTitle(title : String)
    }
}

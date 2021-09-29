package ir.irezaa.cryptoprice.token_item

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject


@RibInteractor
class TokenItemInteractor : Interactor<TokenItemInteractor.TokenItemPresenter, TokenItemRouter>() {

  @Inject
  lateinit var presenter: TokenItemPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

  }

  override fun willResignActive() {
    super.willResignActive()

  }


  interface TokenItemPresenter
}

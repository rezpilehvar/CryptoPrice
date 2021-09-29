package ir.irezaa.cryptoprice.token_list

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import ir.irezaa.cryptoprice.token_list.data.Token
import ir.irezaa.cryptoprice.token_list.data.TokenRepository
import kotlinx.coroutines.*
import javax.inject.Inject


@RibInteractor
class TokenListInteractor : Interactor<TokenListInteractor.TokenListPresenter, TokenListRouter>() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var presenter: TokenListPresenter

    @Inject
    lateinit var repository: TokenRepository

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.tokenItemPreview {
            router.presentTokenItem(it)
        }

        coroutineScope.launch {
          val tokenList = repository.getTokenList()

          withContext(Dispatchers.Main) {
            presenter.updateList(tokenList)
          }
        }
    }

    override fun willResignActive() {
        super.willResignActive()
        presenter.tokenItemPreview(null)
        coroutineScope.cancel()
    }


    interface TokenListPresenter {
        fun updateList(list : List<Token>)
        fun tokenItemPreview(callBack : ((Token) -> Unit)?)
    }
}

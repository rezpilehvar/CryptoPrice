package ir.irezaa.cryptoprice.root.token.list

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdater
import ir.irezaa.cryptoprice.root.token.data.Token
import ir.irezaa.cryptoprice.root.token.data.TokenRepository
import kotlinx.coroutines.*
import javax.inject.Inject


@RibInteractor
class TokenListInteractor : Interactor<TokenListInteractor.TokenListPresenter, TokenListRouter>() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var presenter: TokenListPresenter

    @Inject
    lateinit var repository: TokenRepository

    @Inject
    lateinit var listener : Listener

    @Inject
    lateinit var titleUpdater: ToolbarTitleUpdater

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.tokenItemPreview {
            listener.requestTokenPreview(it)
        }

        coroutineScope.launch {
            val tokenList = repository.getTokenList()

            withContext(Dispatchers.Main) {
                presenter.updateList(tokenList)
            }
        }

        titleUpdater.updateTitle("Token List")
    }

    override fun willResignActive() {
        super.willResignActive()
        presenter.tokenItemPreview(null)
        coroutineScope.cancel()
    }


    interface TokenListPresenter {
        fun updateList(list: List<Token>)
        fun tokenItemPreview(callBack: ((Token) -> Unit)?)
    }

    interface Listener {
        fun requestTokenPreview(token: Token)
    }
}

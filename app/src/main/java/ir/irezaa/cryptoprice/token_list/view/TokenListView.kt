package ir.irezaa.cryptoprice.token_list.view

import android.content.Context
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.irezaa.cryptoprice.token_list.TokenListInteractor
import ir.irezaa.cryptoprice.token_list.data.Token
import ir.irezaa.cryptoprice.token_list.view.adapter.TokenItemClickListener
import ir.irezaa.cryptoprice.token_list.view.adapter.TokenListAdapter


class TokenListView constructor(
    context: Context
) : FrameLayout(context), TokenListInteractor.TokenListPresenter,TokenItemClickListener {
    private val recyclerView = RecyclerView(context)
    private val tokenListAdapter = TokenListAdapter(this)
    private var requestItemPreviewCallback: ((Token) -> Unit)? = null

    init {
        addView(recyclerView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

        recyclerView.apply {
            adapter = tokenListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun updateList(list: List<Token>) {
        tokenListAdapter.update(list)
    }

    override fun tokenItemPreview(callBack: ((Token) -> Unit)?) {
        requestItemPreviewCallback = callBack
    }


    override fun onTokenItemClick(token: Token) {
        requestItemPreviewCallback?.invoke(token)
    }
}

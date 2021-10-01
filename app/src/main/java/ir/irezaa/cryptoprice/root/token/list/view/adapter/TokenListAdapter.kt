package ir.irezaa.cryptoprice.root.token.list.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.irezaa.cryptoprice.R
import ir.irezaa.cryptoprice.root.token.data.Token
import ir.irezaa.cryptoprice.root.token.list.view.cell.TokenCell

class TokenListAdapter(private val itemClickListener: TokenItemClickListener) :
    RecyclerView.Adapter<TokenCell>() {
    private val tokenList = mutableListOf<Token>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokenCell {
        return TokenCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_token, parent, false),
            itemClickListener
        )
    }

    override fun onBindViewHolder(holder: TokenCell, position: Int) {
        holder.bind(tokenList[position])
    }

    override fun getItemCount(): Int {
        return tokenList.size
    }

    fun update(newTokenList: List<Token>) {
        val oldTokens: List<Token> = ArrayList(this.tokenList)
        val diffResult = DiffUtil.calculateDiff(
            TokenDiffCallback(oldTokens, newTokenList),
            true
        )


        tokenList.clear()
        tokenList.addAll(newTokenList)

        diffResult.dispatchUpdatesTo(this)
    }
}

interface TokenItemClickListener {
    fun onTokenItemClick(token: Token)
}

private class TokenDiffCallback(
    private val oldItemList: List<Token>,
    private val newItemList: List<Token>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItemList.size

    override fun getNewListSize() = newItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItemList[oldItemPosition]
        val newItem = newItemList[newItemPosition]

        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItemList[oldItemPosition]
        val newItem = newItemList[newItemPosition]

        return oldItem == newItem
    }
}

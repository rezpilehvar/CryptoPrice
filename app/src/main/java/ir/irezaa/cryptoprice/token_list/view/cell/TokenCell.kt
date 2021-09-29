package ir.irezaa.cryptoprice.token_list.view.cell

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.irezaa.cryptoprice.R
import ir.irezaa.cryptoprice.token_list.data.Token
import ir.irezaa.cryptoprice.token_list.view.adapter.TokenItemClickListener

class TokenCell(itemView: View,private val itemClickListener: TokenItemClickListener) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.cell_token_nameTextView)
    private val priceTextView: TextView = itemView.findViewById(R.id.cell_token_priceTextView)

    lateinit var currentToken : Token

    init {
        itemView.setOnClickListener {
            itemClickListener.onTokenItemClick(currentToken)
        }
    }

    fun bind(token: Token) {
        currentToken = token
        nameTextView.text = "Name: ${token.name}"
        priceTextView.text = "Value: ${token.value}"
    }
}
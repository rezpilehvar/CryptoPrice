package ir.irezaa.cryptoprice.root.token.item

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView


class TokenItemView constructor(context: Context) : FrameLayout(context),
    TokenItemInteractor.TokenItemPresenter {

    private val titleTextView = TextView(context)

    init {
        setBackgroundColor(Color.WHITE)
        addView(titleTextView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))

        titleTextView.apply {
            (layoutParams as LayoutParams).gravity = Gravity.CENTER
            setTextColor(Color.BLACK)
        }

    }

    override fun setTokenTitle(title: String) {
        titleTextView.text = title
    }
}

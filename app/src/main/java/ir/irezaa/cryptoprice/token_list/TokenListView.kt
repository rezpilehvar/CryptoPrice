package ir.irezaa.cryptoprice.token_list

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link TokenListBuilder.TokenListScope}.
 */
class TokenListView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), TokenListInteractor.TokenListPresenter

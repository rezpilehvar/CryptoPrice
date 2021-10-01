package ir.irezaa.cryptoprice.root

import android.content.Context
import android.widget.LinearLayout

class RootView(
    context: Context
) : LinearLayout(context), RootInteractor.RootPresenter {

    init {
        orientation = VERTICAL
    }
}

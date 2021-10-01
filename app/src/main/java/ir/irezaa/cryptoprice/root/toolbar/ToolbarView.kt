package ir.irezaa.cryptoprice.root.toolbar

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import ir.irezaa.cryptoprice.R

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), ToolbarInteractor.ToolbarPresenter {
    private lateinit var titleTextView : TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        titleTextView = findViewById(R.id.toolbar_titleTextView)
    }
    override fun setTitle(title: String) {
        titleTextView.text = title
    }
}

package ir.irezaa.cryptoprice.root.token.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.ViewBuilder
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdater
import ir.irezaa.cryptoprice.root.token.item.di.component.DaggerTokenItemComponent
import ir.irezaa.cryptoprice.root.token.data.Token


class TokenItemBuilder(dependency: ParentComponent) : ViewBuilder<TokenItemView, TokenItemRouter, TokenItemBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup , token : Token): TokenItemRouter {
    val view = createView(parentViewGroup)
    val interactor = TokenItemInteractor()
    val component = DaggerTokenItemComponent.builder()
        .parentComponent(dependency)
        .token(token)
        .view(view)
        .interactor(interactor)
        .build()
    return component.tokenItemRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): TokenItemView {
    return TokenItemView(inflater.context)
  }

  interface ParentComponent {
      fun toolbarTitleUpdater() : ToolbarTitleUpdater
  }


  interface BuilderComponent {
    fun tokenItemRouter(): TokenItemRouter
  }
}

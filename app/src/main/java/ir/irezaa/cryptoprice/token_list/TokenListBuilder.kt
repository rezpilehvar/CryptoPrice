package ir.irezaa.cryptoprice.token_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.ViewBuilder
import ir.irezaa.cryptoprice.token_list.di.component.DaggerTokenListComponent


class TokenListBuilder(dependency: ParentComponent) : ViewBuilder<TokenListView, TokenListRouter, TokenListBuilder.ParentComponent>(dependency) {


  fun build(parentViewGroup: ViewGroup): TokenListRouter {
    val view = createView(parentViewGroup)
    val interactor = TokenListInteractor()
    val component = DaggerTokenListComponent.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.tokenListRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): TokenListView {
    return TokenListView(inflater.context)
  }

  interface ParentComponent

  interface BuilderComponent {
    fun tokenListRouter(): TokenListRouter
  }
}

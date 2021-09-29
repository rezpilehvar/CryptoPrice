package ir.irezaa.cryptoprice.token_item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import ir.irezaa.cryptoprice.token_item.di.component.DaggerTokenItemComponent
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope


class TokenItemBuilder(dependency: ParentComponent) : ViewBuilder<TokenItemView, TokenItemRouter, TokenItemBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup): TokenItemRouter {
    val view = createView(parentViewGroup)
    val interactor = TokenItemInteractor()
    val component = DaggerTokenItemComponent.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.tokenItemRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): TokenItemView {
    return TokenItemView(inflater.context)
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }


  interface BuilderComponent {
    fun tokenItemRouter(): TokenItemRouter
  }
}

package ir.irezaa.cryptoprice.root.token

import com.uber.rib.core.Builder
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.InteractorBaseComponent
import java.lang.annotation.Retention

import javax.inject.Qualifier
import javax.inject.Scope

import dagger.Provides
import dagger.BindsInstance
import ir.irezaa.cryptoprice.root.RootView
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdater
import ir.irezaa.cryptoprice.root.token.data.TokenListApi
import ir.irezaa.cryptoprice.root.token.item.TokenItemBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListInteractor
import retrofit2.Retrofit

import java.lang.annotation.RetentionPolicy.CLASS

class TokenBuilder(dependency: ParentComponent) :
    Builder<TokenRouter, TokenBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [TokenRouter].
     *
     * @return a new [TokenRouter].
     */
    fun build(): TokenRouter {
        val interactor = TokenInteractor()
        val component = DaggerTokenBuilder_Component.builder()
            .parentComponent(dependency)
            .interactor(interactor)
            .build()

        return component.tokenRouter()
    }

    interface ParentComponent {
        fun rootView(): RootView
        fun retrofit() : Retrofit
        fun toolbarTitleUpdate() : ToolbarTitleUpdater
    }


    @dagger.Module
    abstract class Module {

        @dagger.Module
        companion object {
            @TokenScope
            @Provides
            fun tokenListListener(tokenInteractor: TokenInteractor): TokenListInteractor.Listener {
                return tokenInteractor.TokenPreviewRequestListener()
            }

            @TokenScope
            @Provides
            @JvmStatic
            internal fun presenter(): EmptyPresenter {
                return EmptyPresenter()
            }

            @Provides
            @TokenScope
            internal fun provideTokenListApi(retrofit: Retrofit): TokenListApi {
                return retrofit.create(TokenListApi::class.java)
            }

            @TokenScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                interactor: TokenInteractor,
                rootView: RootView
            ): TokenRouter {
                return TokenRouter(
                    rootView, interactor, component, TokenListBuilder(component),
                    TokenItemBuilder(component)
                )
            }

        }
    }


    @TokenScope
    @dagger.Component(
        modules = [Module::class],
        dependencies = [ParentComponent::class]
    )
    interface Component : InteractorBaseComponent<TokenInteractor>, BuilderComponent,
        TokenListBuilder.ParentComponent, TokenItemBuilder.ParentComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: TokenInteractor): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }

    }

    interface BuilderComponent {
        fun tokenRouter(): TokenRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class TokenScope


    @Qualifier
    @Retention(CLASS)
    internal annotation class TokenInternal
}

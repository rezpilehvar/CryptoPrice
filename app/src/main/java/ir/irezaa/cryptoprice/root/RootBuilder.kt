package ir.irezaa.cryptoprice.root

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import ir.irezaa.cryptoprice.root.token.TokenBuilder
import ir.irezaa.cryptoprice.root.toolbar.ToolbarBuilder
import retrofit2.Retrofit
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope


class RootBuilder(dependency: ParentComponent) :
    ViewBuilder<RootView, RootRouter, RootBuilder.ParentComponent>(dependency) {

    fun build(parentViewGroup: ViewGroup): RootRouter {
        val view = createView(parentViewGroup)
        val interactor = RootInteractor()
        val component = DaggerRootBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.rootRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RootView {
        return RootView(inflater.context)
    }

    interface ParentComponent {
        fun retrofit(): Retrofit
    }

    @dagger.Module
    abstract class Module {

        @RootScope
        @Binds
        internal abstract fun presenter(view: RootView): RootInteractor.RootPresenter

        @dagger.Module
        companion object {

            @RootScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: RootView,
                interactor: RootInteractor
            ): RootRouter {
                return RootRouter(
                    view,
                    interactor,
                    component,
                    ToolbarBuilder(component),
                    TokenBuilder(component)
                )
            }

            @RootScope
            @Provides
            internal fun provideToolbarTitleUpdater() : ToolbarTitleUpdater {
                return ToolbarTitleUpdater()
            }
        }
    }

    @RootScope
    @dagger.Component(
        modules = [Module::class],
        dependencies = [ParentComponent::class]
    )
    interface Component : InteractorBaseComponent<RootInteractor>, BuilderComponent,
        TokenBuilder.ParentComponent, ToolbarBuilder.ParentComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: RootInteractor): Builder

            @BindsInstance
            fun view(view: RootView): Builder

            fun parentComponent(component: ParentComponent): Builder

            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun rootRouter(): RootRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class RootScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class RootInternal
}

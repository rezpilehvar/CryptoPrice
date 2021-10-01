package ir.irezaa.cryptoprice.root.toolbar

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import ir.irezaa.cryptoprice.R
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdater
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdaterSource
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope


class ToolbarBuilder(dependency: ParentComponent) :
    ViewBuilder<ToolbarView, ToolbarRouter, ToolbarBuilder.ParentComponent>(dependency) {

    fun build(parentViewGroup: ViewGroup): ToolbarRouter {
        val view = createView(parentViewGroup)
        val interactor = ToolbarInteractor()
        val component = DaggerToolbarBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.toolbarRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ToolbarView {
        return inflater.inflate(R.layout.toolbar, parentViewGroup, false) as ToolbarView
    }

    interface ParentComponent {
        fun toolbarTitleUpdaterSource() : ToolbarTitleUpdaterSource
    }

    @dagger.Module
    abstract class Module {

        @ToolbarScope
        @Binds
        internal abstract fun presenter(view: ToolbarView): ToolbarInteractor.ToolbarPresenter

        @dagger.Module
        companion object {

            @ToolbarScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: ToolbarView,
                interactor: ToolbarInteractor
            ): ToolbarRouter {
                return ToolbarRouter(view, interactor, component)
            }
        }
    }

    @ToolbarScope
    @dagger.Component(modules = [Module::class], dependencies = [ParentComponent::class])
    interface Component : InteractorBaseComponent<ToolbarInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: ToolbarInteractor): Builder

            @BindsInstance
            fun view(view: ToolbarView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun toolbarRouter(): ToolbarRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class ToolbarScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class ToolbarInternal
}

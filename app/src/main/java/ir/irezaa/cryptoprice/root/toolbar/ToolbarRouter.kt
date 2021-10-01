package ir.irezaa.cryptoprice.root.toolbar

import com.uber.rib.core.ViewRouter


class ToolbarRouter(
    view: ToolbarView,
    interactor: ToolbarInteractor,
    component: ToolbarBuilder.Component) : ViewRouter<ToolbarView, ToolbarInteractor>(view, interactor, component)

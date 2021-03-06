package ir.irezaa.cryptoprice.root.toolbar

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdater
import ir.irezaa.cryptoprice.root.ToolbarTitleUpdaterSource
import javax.inject.Inject

@RibInteractor
class ToolbarInteractor : Interactor<ToolbarInteractor.ToolbarPresenter, ToolbarRouter>() {

    private val disposables = CompositeDisposable()

    @Inject
    lateinit var presenter: ToolbarPresenter

    @Inject
    lateinit var toolbarTitleUpdaterSource: ToolbarTitleUpdaterSource

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.setTitle("test")

        disposables.add(
            toolbarTitleUpdaterSource
                .title
                .subscribeBy {
                    presenter.setTitle(it)
                }
        )
    }

    override fun willResignActive() {
        super.willResignActive()
        disposables.clear()
    }

    interface ToolbarPresenter {
        fun setTitle(title: String)
    }
}

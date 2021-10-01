package ir.irezaa.cryptoprice.root

import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.Relay
import javax.inject.Inject


interface ToolbarTitleUpdaterSource {
    var title: Relay<String>
}

interface ToolbarTitleUpdater {
    fun updateTitle(title: String)
}

@RootBuilder.RootScope
class ToolbarTitleUpdaterImp @Inject constructor() : ToolbarTitleUpdaterSource, ToolbarTitleUpdater {
    override var title = BehaviorRelay.createDefault("").toSerialized()

    override fun updateTitle(title: String) = this.title.accept(title)
}
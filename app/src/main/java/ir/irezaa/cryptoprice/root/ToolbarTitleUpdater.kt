package ir.irezaa.cryptoprice.root

import com.jakewharton.rxrelay2.BehaviorRelay


class ToolbarTitleUpdater {
    val title = BehaviorRelay.createDefault("").toSerialized()

    fun updateTitle(title: String) = this.title.accept(title)
}
package ir.irezaa.cryptoprice

import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.root.RootBuilder
import ir.irezaa.cryptoprice.root.token.list.TokenListBuilder
import javax.inject.Singleton

class LaunchActivity : RibActivity() {
    @Singleton
    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *> {
        val applicationComponent = (applicationContext as ApplicationClass).appComponent
        return RootBuilder(applicationComponent)
            .build(parentViewGroup)
    }

    override fun onUnhandledBackPressed() {
        super.onUnhandledBackPressed()
    }
}
package ir.irezaa.cryptoprice

import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter
import ir.irezaa.cryptoprice.token_list.TokenListBuilder
import javax.inject.Singleton

class LaunchActivity : RibActivity() {
    @Singleton
    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *> {
        val applicationComponent = (applicationContext as ApplicationClass).appComponent
        return TokenListBuilder(applicationComponent)
            .build(parentViewGroup)
    }
}
package ir.irezaa.cryptoprice.root.token.list

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper
import ir.irezaa.cryptoprice.root.token.list.view.TokenListView

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TokenListRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: TokenListBuilder.Component
  @Mock internal lateinit var interactor: TokenListInteractor
  @Mock internal lateinit var view: TokenListView

  private var router: TokenListRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = TokenListRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}


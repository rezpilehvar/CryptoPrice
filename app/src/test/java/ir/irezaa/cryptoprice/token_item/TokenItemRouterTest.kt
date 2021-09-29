package ir.irezaa.cryptoprice.token_item

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TokenItemRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: TokenItemBuilder.Component
  @Mock internal lateinit var interactor: TokenItemInteractor
  @Mock internal lateinit var view: TokenItemView

  private var router: TokenItemRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = TokenItemRouter(view, interactor, component)
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


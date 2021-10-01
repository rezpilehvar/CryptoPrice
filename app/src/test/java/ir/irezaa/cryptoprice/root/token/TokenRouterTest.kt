package ir.irezaa.cryptoprice.root.token

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TokenRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: TokenBuilder.Component
  @Mock internal lateinit var interactor: TokenInteractor

  private var router: TokenRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = TokenRouter(interactor, component)
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

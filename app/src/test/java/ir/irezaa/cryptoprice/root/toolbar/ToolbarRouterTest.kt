package ir.irezaa.cryptoprice.root.toolbar

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ToolbarRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: ToolbarBuilder.Component
  @Mock internal lateinit var interactor: ToolbarInteractor
  @Mock internal lateinit var view: ToolbarView

  private var router: ToolbarRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = ToolbarRouter(view, interactor, component)
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


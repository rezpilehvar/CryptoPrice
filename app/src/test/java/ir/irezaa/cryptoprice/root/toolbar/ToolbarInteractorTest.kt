package ir.irezaa.cryptoprice.root.toolbar

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ToolbarInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ToolbarInteractor.ToolbarPresenter
  @Mock internal lateinit var router: ToolbarRouter

  private var interactor: ToolbarInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestToolbarInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ToolbarInteractor.ToolbarPresenter, ToolbarRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
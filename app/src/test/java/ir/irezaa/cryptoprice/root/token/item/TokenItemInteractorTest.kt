package ir.irezaa.cryptoprice.root.token.item

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TokenItemInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: TokenItemInteractor.TokenItemPresenter
  @Mock internal lateinit var router: TokenItemRouter

  private var interactor: TokenItemInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestTokenItemInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<TokenItemInteractor.TokenItemPresenter, TokenItemRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
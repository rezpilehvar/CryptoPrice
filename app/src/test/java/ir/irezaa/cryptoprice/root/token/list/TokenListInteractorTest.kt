package ir.irezaa.cryptoprice.root.token.list

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TokenListInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: TokenListInteractor.TokenListPresenter
  @Mock internal lateinit var router: TokenListRouter

  private var interactor: TokenListInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestTokenListInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<TokenListInteractor.TokenListPresenter, TokenListRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
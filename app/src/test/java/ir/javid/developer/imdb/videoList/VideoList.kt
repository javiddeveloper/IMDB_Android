package ir.javid.developer.imdb.videoList

import android.text.method.MovementMethod
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import ir.javid.developer.imdb.data.repository.MovieManager
import ir.javid.developer.imdb.data.rest.model.Address
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.tools.ContextModel
import ir.javid.developer.imdb.tools.MockServerRunner
import org.awaitility.Awaitility
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
//import org.powermock.api.mockito.PowerMockito
//import org.powermock.api.mockito.internal.configuration.PowerMockitoSpyAnnotationEngine

import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLooper

/**
 * Developed by javid
 */

@RunWith(RobolectricTestRunner::class)
class VideoList : MockServerRunner() {

    @Mock
    private val mockedConfig: Address? = null

    @Before
    fun prepareMockServer() {
        MockitoAnnotations.initMocks(this)
        ContextModel.context = InstrumentationRegistry.getInstrumentation().targetContext
        PowerMockito.`when`(Address.BASE_URL).thenReturn("http://localhost:8000")
//        setMock(mockedConfig)
    }

    @Test
    fun ListVideo_ReturnSuccessResponse() {
        val size = 10
        MovieManager.instance.executeImdbList("batman").subscribe(
            Consumer {
                Truth.assertWithMessage("test fail")
                    .that(size)
                    .isEqualTo(it.search.size)

            }
        )
    }
}
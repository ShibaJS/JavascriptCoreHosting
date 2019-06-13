package moe.tlaster.javascriptcorehosting

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        JSContext().apply {
            this.evaluateScript("function hello(){return 'hello world!';}")
            val result = this.property("hello").toFunction().call().toString()
            assert(result == "hello world!")
        }
    }
}

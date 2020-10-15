package mahmoudroid.uitestespresso

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    //    val fakeString = "Hellp, I'm fake string"
//
//    @Mock
//    lateinit var context: Context
//
//
//
//    @Mock lateinit var list : ArrayList<String>
//
//    @Test
//    fun testMock() {
//        // this line is necessary
//        MockitoAnnotations.initMocks(this)
//
//
//        list.add("as")
//        verify(list).add("as")
//        Assert.assertEquals(1,list.size)
//    }
//
//    @Test
//    fun testSpy() {
//        // this line is necessary
//        MockitoAnnotations.initMocks(this)
//
//        val aaax = spy(ArrayList<String>())
//        aaax.add("as")
//        verify(aaax).add("as")
//        Assert.assertEquals(1,aaax.size)
//    }


/*    @Test
    fun showMessage(){
        // this line is necessary
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(context.getString(R.string.app_name)).thenReturn(fakeString)

        val instance = TestClass(context)

        val result = instance.readStringusingContext()


        Assert.assertThat(result, `is`(fakeString))

    }*/



}
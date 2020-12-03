package mahmoudroid.uitestespresso.ui.movie

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import kotlinx.android.synthetic.main.fragment_directors.view.*
import mahmoudroid.uitestespresso.R
import mahmoudroid.uitestespresso.data.DummyMovies.INFINITY_WAR
import mahmoudroid.uitestespresso.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{


    @Test
    fun test_isDircrorsListVisible() {
        val movie = INFINITY_WAR
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors",movie.directors)

        val scenario = launchFragmentInContainer<DirectorsFragment>(
            factory = fragmentFactory,
            fragmentArgs = bundle
        )

        onView(withId(R.id.directors_text)).check(matches(withText(movie.directors.toString())))

    }
}
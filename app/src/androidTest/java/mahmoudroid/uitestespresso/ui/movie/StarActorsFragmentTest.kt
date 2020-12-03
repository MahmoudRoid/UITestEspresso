package mahmoudroid.uitestespresso.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import mahmoudroid.uitestespresso.R
import mahmoudroid.uitestespresso.data.DummyMovies
import mahmoudroid.uitestespresso.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun test_isActorsListVisible() {
        val movie = DummyMovies.THE_RUNDOWN
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors",movie.star_actors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            factory = fragmentFactory,
            fragmentArgs = bundle
        )

        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    DirectorsFragment.stringBuilderForDirectors(movie.star_actors!!)
                )
            )
        )

    }

}
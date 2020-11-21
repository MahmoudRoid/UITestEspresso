package mahmoudroid.uitestespresso.ui.movie

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import mahmoudroid.uitestespresso.R
import mahmoudroid.uitestespresso.data.DummyMovies.THE_RUNDOWN
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    @Test
    fun test_isMovieDataVisible() {

        val movie = THE_RUNDOWN
        val fragmentFactory = FragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id",movie.id)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            factory = fragmentFactory,
            fragmentArgs = bundle
        )

        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))


    }
}
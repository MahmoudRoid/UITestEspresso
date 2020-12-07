package mahmoudroid.uitestespresso.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bumptech.glide.request.RequestOptions
import io.mockk.every
import io.mockk.mockk
import mahmoudroid.uitestespresso.R
import mahmoudroid.uitestespresso.data.Movie
import mahmoudroid.uitestespresso.data.source.MoviesDataSource
import mahmoudroid.uitestespresso.data.source.MoviesRemoteDataSource
import mahmoudroid.uitestespresso.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    @Test
    fun test_isDataVisible() {
        val movieId = 1
        val title = "The Rundown"
        val description = "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                "becomes involved in the fight against an oppressive town operator and the search " +
                "for a legendary treasure."

        val movie = Movie(
            movieId,
            title,
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            description ,
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        )


        val moviesDataSource = mockk<MoviesRemoteDataSource>()
        every {
            moviesDataSource.getMovie(any())
        } returns movie

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.default_image)
            .error(R.drawable.default_image)

        val movieFragmentFactory = MovieFragmentFactory(requestOptions,moviesDataSource)

        val bundle = Bundle()
        bundle.putInt("movie_id", 885)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = movieFragmentFactory
        )

        // VERIFY
        onView(withId(R.id.movie_title)).check(matches(withText(title)))
        onView(withId(R.id.movie_description)).check(matches(withText(description)))
    }
}
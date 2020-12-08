package mahmoudroid.uitestespresso.ui.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import mahmoudroid.uitestespresso.R
import mahmoudroid.uitestespresso.data.FakeMovieData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieListFragmentTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val test_item_number = 4
    val test_movie = FakeMovieData.movies[test_item_number]

    @Test
    fun test_isListFragmentVisible_onAppLaunch(){
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectListItem_isDetailFragmentVisible(){
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(test_item_number, click()))

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(test_movie.title)))
    }

    @Test
    fun test_backNavigation_toMovieListFragment(){
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(test_item_number, click()))

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(test_movie.title)))

        pressBack()

        // Confirm MovieListFragment in view
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_navDirectorsFragment_validateDirectorsList(){
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(test_item_number, click()))

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(test_movie.title)))

        // click on directors
        onView(withId(R.id.movie_directiors)).perform(click())

        // Confirm correct directors are visible
        onView(withId(R.id.directors_text))
            .check(matches(withText(
                DirectorsFragment.stringBuilderForDirectors(test_movie.directors!!)
            )))
    }

    @Test
    fun test_navStarActorsFragment_validateActorsList() {
        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(test_item_number, click()))

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(test_movie.title)))

        // Nav to DirectorsFragment
        onView(withId(R.id.movie_star_actors)).perform(click())

        // Confirm correct directors are visible
        onView(withId(R.id.star_actors_text))
            .check(matches(withText(
                StarActorsFragment.stringBuilderForStarActors(test_movie.star_actors!!)
            )))
    }

}
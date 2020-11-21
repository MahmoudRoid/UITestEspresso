package mahmoudroid.uitestespresso.data.source

import mahmoudroid.uitestespresso.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?

}